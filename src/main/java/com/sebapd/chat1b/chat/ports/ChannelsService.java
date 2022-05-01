package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Channel;

import java.util.List;

public interface ChannelsService {

    void addChannel(String channelName);
    void deleteChannel(String channelName);
    List<Channel> getChannelList();
}
