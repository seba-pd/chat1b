package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotExistInChannel;
import com.sebapd.chat1b.server.ports.ChannelsRepository;
import com.sebapd.chat1b.server.ports.JMSMessageService;
import com.sebapd.chat1b.server.ports.MessageRepository;
import com.sebapd.chat1b.server.ports.MessageService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatMessageService implements MessageService {

    private final MessageRepository messageRepository;
    private final ChannelsRepository channelsRepository;
    private final JMSMessageService jmsMessageService;

    @Override
    public void send(Message message, String channelName) {

        message.setCreateTime(Timestamp.from(Instant.now()));
        message.setMessageId(UUID.randomUUID());

        toDatabase(message, channelName);
        jmsMessageService.toBroker(message,channelName);
    }

    private void toDatabase(Message message, String channelName) {
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        var membersNames = channel.getChannelMembers()
                .stream()
                .map(Member::getMemberName)
                .toList();
        if (membersNames.contains(message.getMemberName())) {
            messageRepository.sendMessage(message, channel);
        } else
            throw new MemberNotExistInChannel();
    }
}
