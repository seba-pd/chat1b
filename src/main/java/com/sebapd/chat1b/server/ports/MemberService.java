package com.sebapd.chat1b.server.ports;

import java.util.List;

public interface MemberService {

    void addChatMember(String name);
    void removeChatMemberByName(String name);
    void checkIfMemberExist(String memberName);
    List<String> getMemberChannels(String memberName);
}
