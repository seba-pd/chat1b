package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void addChatMember(Member member);
    void removeChatMemberByName(String name);
    Optional<Member> getChatMemberByName(String name);
    List<Channel> getMemberChannels(String memberName);
}
