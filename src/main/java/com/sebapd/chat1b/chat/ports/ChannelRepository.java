package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.Member;

import java.util.List;

public interface ChannelRepository {

    void addMemberToChannel(Member member, Channel channel);
    void removeChannelMember(Member member, Channel channel);
    List<Member> getChannelMembers(Channel channel);
}
