package com.sebapd.chat1b.chat.domain;

import com.sebapd.chat1b.chat.ports.ChannelsRepository;
import com.sebapd.chat1b.chat.ports.ChannelsService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RequiredArgsConstructor
public class ChatChannelsService implements ChannelsService {

    private final ChannelsRepository channelsRepository;
    // to do interception ?
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void addChannel(String name) {
        lock.writeLock().lock();
        if (!channelAlreadyExist(name)) {
            channelsRepository.addChannel(new Channel(name));
        } else {
            throw new ChannelAlreadyExistException();
        }
        lock.writeLock().unlock();
    }

    @Override
    public List<Channel> channelList() {
        lock.readLock().lock();
        List<Channel> channels = channelsRepository.getChannelList();
        lock.readLock().unlock();
        return channels;
    }

    private boolean channelAlreadyExist(String channelName){
        List<Channel> channels = channelsRepository.getChannelList();
        return channels.stream().map(Channel::getName).anyMatch(c -> c.equals(channelName));
    }
}
