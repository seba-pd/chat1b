package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.MemberAlreadyExistInChannelException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotExistInChannelException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotFoundException;
import com.sebapd.chat1b.server.ports.*;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatChannelService implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ChannelsRepository channelsRepository;
    private final MemberRepository memberRepository;
    private final JMSMessageService jmsMessageService; // decorator/interceptor?


    @Override
    public void addMemberToChannel(String memberName, String channelName) {
        var member = memberRepository.getChatMemberByName(memberName)
                .orElseThrow(MemberNotFoundException::new);
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        if (checkIfMemberExistInChannel(channel, member)) throw new MemberAlreadyExistInChannelException();

        channelRepository.addMemberToChannel(member, channel);

        jmsMessageService.toBroker(Message.builder()
                .content(" join to channel")
                .channelName(channelName)
                .memberName(memberName)
                .createTime(Timestamp.from(Instant.now()))
                .build());
    }

    @Override
    public void removeChannelMember(String memberName, String channelName) {
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        var member = memberRepository.getChatMemberByName(memberName)
                .orElseThrow(MemberNotFoundException::new);
        if (!checkIfMemberExistInChannel(channel, member)) throw new MemberNotExistInChannelException();

        channelRepository.removeChannelMember(member, channel);

        jmsMessageService.toBroker(Message.builder()
                .content(memberName + " left from channel")
                .channelName(channelName)
                .memberName(memberName)
                .createTime(Timestamp.from(Instant.now()))
                .build());
    }

    @Override
    public List<Message> getHistory(String channelName, String memberName) {
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        var member = memberRepository.getChatMemberByName(memberName)
                .orElseThrow(MemberNotFoundException::new);
        if (!checkIfMemberExistInChannel(channel, member)) throw new MemberNotExistInChannelException();
        var messageList = channel.getMessageList()
                .stream()
                .filter(message -> message.getAccessMembersList().contains(memberName))
                .toList();
        messageList.forEach(message -> message.setChannelName(channelName));
        return messageList;
    }

    private boolean checkIfMemberExistInChannel(Channel channel, Member member) {
        return channel.getChannelMembers()
                .stream()
                .anyMatch(m -> m.getMemberName().equals(member.getMemberName()));
    }
}
