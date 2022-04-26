package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Channel;

import java.util.List;
import java.util.Optional;

public interface ChannelsRepository {

    void addChannel(Channel channel);
    List<Channel> getChannelList();
    Optional<Channel> getChannelById(Long id);
}