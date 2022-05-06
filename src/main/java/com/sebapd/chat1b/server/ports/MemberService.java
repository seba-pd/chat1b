package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.Member;

import java.util.List;

public interface MemberService {

    void addChatMember(Member member);
    void removeChatMemberByName(String name);
    void checkIfMemberExist(String memberName);
    List<String> getMemberChannels(String memberName);
}
