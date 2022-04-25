package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.ChatMember;

import java.util.List;

public interface ChannelRepository {

    void addChannelMember(ChatMember chatMember, Long channelId);
    void removeChannelMember(Long chatMemberId, Channel channel);
    List<ChatMember> getChannelMembers(Channel channel);
}
