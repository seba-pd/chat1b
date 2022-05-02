package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    void addChatMember(Member member);
    void removeChatMemberByName(String name);
    Optional<Member> getChatMemberByName(String name);
}
