package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Message;

import java.util.List;

public interface ChannelService {

    void addMemberToChannel(String chatMemberName, String channelName);
    void removeChannelMember(String chatMemberName, String channelName);
    List<Message> getHistory(String channelName, String memberName);
}
