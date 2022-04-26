package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.ports.ChannelsRepository;

import java.util.List;
import java.util.Optional;

public class JpaChatChannelsRepositoryAdapter implements ChannelsRepository {

    @Override
    public void addChannel(Channel channel) {

    }

    @Override
    public List<Channel> getChannelList() {
        return null;
    }

    @Override
    public Optional<Channel> getChannelById(Long id) {
        return Optional.empty();
    }
}
