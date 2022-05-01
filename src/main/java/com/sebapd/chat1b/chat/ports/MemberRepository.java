package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Member;

public interface MemberRepository {

    void addChatMember(Member member);
    void removeChatMemberByName(String name);
    Member getChatMemberByName(String name);
}
