package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.Member;

import java.util.List;

public interface ChannelRepository {

    void addMemberToChannel(Member member, Channel channel);
    void removeChannelMember(Member member, Channel channel);
    List<Member> getChannelMembers(Channel channel);

}
