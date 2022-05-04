package com.sebapd.chat1b.server.ports;

public interface MemberService {

    void addChatMember(String name);
    void removeChatMemberByName(String name);
}
