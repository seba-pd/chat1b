package com.sebapd.chat1b.chat.domain;

import com.sebapd.chat1b.chat.ports.ChannelRepository;
import com.sebapd.chat1b.chat.ports.ChannelService;
import com.sebapd.chat1b.chat.ports.ChannelsRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ChatChannelService implements ChannelService {

    private ChannelRepository channelRepository;
    private ChannelsRepository channelsRepository;

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
