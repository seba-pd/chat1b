package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.domain.Message;
import com.sebapd.chat1b.chat.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.chat.domain.exceptions.MemberNotExistInChannel;
import com.sebapd.chat1b.chat.ports.*;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatMessageService implements MessageService {

    private final MessageRepository messageRepository;
    private final ChannelsRepository channelsRepository;
    private final ChannelRepository channelRepository;

    @Override
    public void send(Message message, String channelName) {
        message.setCreateDate(Timestamp.from(Instant.now()));
        message.setMessageId(UUID.randomUUID());
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        var members = channelRepository.getChannelMembers(channel);
        var membersNames = members
                .stream()
                .map(Member::getName)
                .toList();
        if(membersNames.contains(message.getAuthor())){
            messageRepository.sendMessage(message,channel);
        }else
            throw new MemberNotExistInChannel();
    }
}
