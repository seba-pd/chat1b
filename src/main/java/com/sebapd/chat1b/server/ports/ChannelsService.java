package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.Channel;

import java.util.List;

public interface ChannelsService {

    void addChannel(Channel channel);
    void deleteChannel(String channelName);
    List<Channel> getChannelList();
}
