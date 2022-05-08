package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.exceptions.ChannelAlreadyExistException;
import com.sebapd.chat1b.server.ports.ChannelsRepository;
import com.sebapd.chat1b.server.ports.ChannelsService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatChannelsService implements ChannelsService {

    private final ChannelsRepository channelsRepository;

    @Override
    public void addChannel(Channel channel) {
        if (!channelAlreadyExist(channel.getChannelName())) {
            channelsRepository.addChannel(channel);
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
