package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.chat.domain.exceptions.MemberNotFoundException;
import com.sebapd.chat1b.chat.ports.ChannelRepository;
import com.sebapd.chat1b.chat.ports.ChannelService;
import com.sebapd.chat1b.chat.ports.ChannelsRepository;
import com.sebapd.chat1b.chat.ports.MemberRepository;
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
        var member = chatMemberRepository.getChatMemberByName(chatMemberName)
                .orElseThrow(MemberNotFoundException::new);
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        channelRepository.addMemberToChannel(member, channel);
    }

    @Override
    public void removeChatMember(String chatMemberName, String channelName) {
        var member = chatMemberRepository.getChatMemberByName(channelName)
                .orElseThrow(MemberNotFoundException::new);
        var channel =  channelsRepository.getChannelByName(channelName)
                        .orElseThrow(ChannelNotFoundException::new);
        channelRepository.removeChannelMember(member, channel);
    }

    @Override
    public List<Member> getChatMembers(String channelName) {
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        return channelRepository.getChannelMembers(channel);
    }
}
