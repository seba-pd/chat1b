package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.ChatMember;

import java.util.List;

public interface ChannelService {

    void addChatMember(ChatMember chatMember, Long channelId);
    void removeChatMember(Long chatMemberId, Long channelId);
    List<ChatMember> getChatMember(Channel channel);
}
