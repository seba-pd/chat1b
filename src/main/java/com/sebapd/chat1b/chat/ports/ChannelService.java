package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Member;

import java.util.List;

public interface ChannelService {

    void addMemberToChannel(String chatMemberName, String channelName);
    void removeChatMember(String chatMemberName, String channelName);
    List<Member> getChatMember(String channelName);
}
