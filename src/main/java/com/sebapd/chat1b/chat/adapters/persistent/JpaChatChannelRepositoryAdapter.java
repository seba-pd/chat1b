package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.ChatMember;
import com.sebapd.chat1b.chat.ports.ChannelRepository;

import java.util.List;

public class JpaChatChannelRepositoryAdapter implements ChannelRepository {

    @Override
    public void addChannelMember(ChatMember chatMember, Long channelId) {

    }

    @Override
    public void removeChannelMember(Long chatMemberId, Channel channel) {

    }

    @Override
    public List<ChatMember> getChannelMembers(Channel channel) {
        return null;
    }
}
