package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.ChatMember;
import com.sebapd.chat1b.chat.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.chat.ports.ChannelRepository;
import com.sebapd.chat1b.chat.ports.ChannelService;
import com.sebapd.chat1b.chat.ports.ChannelsRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatChannelService implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ChannelsRepository channelsRepository;


    @Override
    public void addChatMember(ChatMember chatMember, Long channelId) {
        channelRepository.addChannelMember(chatMember, channelId);
    }

    @Override
    public void removeChatMember(Long chatMemberId, Long channelId) {
        channelRepository.removeChannelMember(chatMemberId, getChannel(channelId));
    }

    @Override
    public List<ChatMember> getChatMember(Channel channel) {
        return channelRepository.getChannelMembers(channel);
    }

    private Channel getChannel(Long channelId){
        return channelsRepository.getChannelById(channelId)
                .orElseThrow(ChannelNotFoundException::new);
    }
}
