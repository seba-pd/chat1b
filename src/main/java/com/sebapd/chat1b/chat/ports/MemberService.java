package com.sebapd.chat1b.chat.ports;

public interface MemberService {

    void addChatMember(String name);
    void removeChatMemberByName(String name);
}
