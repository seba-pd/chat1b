package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.exceptions.ChannelAlreadyExistException;
import com.sebapd.chat1b.chat.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.chat.ports.ChannelsRepository;
import com.sebapd.chat1b.chat.ports.ChannelsService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatChannelsService implements ChannelsService {

    private final ChannelsRepository channelsRepository;
    // to do interception ?
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void addChannel(String name) {
        lock.writeLock().lock();
        if (!channelAlreadyExist(name)) {
            channelsRepository.addChannel(
                    Channel.builder()
                            .channelId(UUID.randomUUID())
                            .channelName(name)
                            .channelMembers(new LinkedList<>())
                            .build());
        } else {
            throw new ChannelAlreadyExistException();
        }
        lock.writeLock().unlock();
    }

    @Override
    public void deleteChannel(String channelName) {
        var channel = channelsRepository.getChannelByName(channelName).orElseThrow(ChannelNotFoundException::new);
        channelsRepository.deleteChannel(channel);
    }

    @Override
    public List<Channel> getChannelList() {
        lock.readLock().lock();
        List<Channel> channels = channelsRepository.getChannelList();
        lock.readLock().unlock();
        return channels;
    }

    private boolean channelAlreadyExist(String channelName) {
        List<Channel> channels = channelsRepository.getChannelList();
        return channels.stream().map(Channel::getChannelName).anyMatch(c -> c.equals(channelName));
    }
}
