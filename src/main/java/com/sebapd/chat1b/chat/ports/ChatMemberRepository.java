package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.ChatMember;

public interface ChatMemberRepository {

    void addChatMember(ChatMember chatMember);
    void removeChatMemberByName(String name);
    ChatMember getChatMemberByName(String name);
}
