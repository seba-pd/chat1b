package com.sebapd.chat1b.chat.ports;

public interface ChatMemberService {

    void addChatMember(String name);
    void removeChatMemberByName(String name);
}
