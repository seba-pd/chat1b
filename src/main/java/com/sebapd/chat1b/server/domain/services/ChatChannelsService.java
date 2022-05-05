package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.exceptions.ChannelAlreadyExistException;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.ports.ChannelsRepository;
import com.sebapd.chat1b.server.ports.ChannelsService;
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

    @Override
    public void addChannel(String name) {
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
    }

    @Override
    public void deleteChannel(String channelName) {
        channelsRepository.deleteChannel(channelName);
    }

    @Override
    public List<Channel> getChannelList() {
        return channelsRepository.getChannelList();
    }

    private boolean channelAlreadyExist(String channelName) {
        List<Channel> channels = channelsRepository.getChannelList();
        return channels.stream().map(Channel::getChannelName).anyMatch(c -> c.equals(channelName));
    }
}
