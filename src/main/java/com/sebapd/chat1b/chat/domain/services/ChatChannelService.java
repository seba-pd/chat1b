package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.chat.ports.*;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatChannelService implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ChannelsRepository channelsRepository;
    private final MemberRepository chatMemberRepository;


    @Override
    public void addMemberToChannel(String chatMemberName, String channelName) {
        var member = chatMemberRepository.getChatMemberByName(chatMemberName);
        var channel = getChannel(channelName);
        channelRepository.addMemberToChannel(member, channel);
    }

    @Override
    public void removeChatMember(String chatMemberName, String channelName) {
        var member = chatMemberRepository.getChatMemberByName(channelName);
        channelRepository.removeChannelMember(member, getChannel(channelName));
    }

    @Override
    public List<Member> getChatMember(String channelName) {
        var channel = getChannel(channelName);
        return channelRepository.getChannelMembers(channel);
    }

    private Channel getChannel(String channelName){
        return channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
    }
}
