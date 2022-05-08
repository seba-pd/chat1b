package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotExistInChannelException;
import com.sebapd.chat1b.server.ports.ChannelsRepository;
import com.sebapd.chat1b.server.ports.MessageRepository;
import com.sebapd.chat1b.server.ports.MessageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@AllArgsConstructor(onConstructor_ = @Inject)
@NoArgsConstructor
public class ChatMessageService implements MessageService {

    private MessageRepository messageRepository;
    private ChannelsRepository channelsRepository;

    @Override
    public void send(Message message, String channelName) {

        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        var membersNames = channel.getChannelMembers()
                .stream()
                .map(Member::getMemberName)
                .toList();
        if (membersNames.contains(message.getMemberName())) {
            messageRepository.sendMessage(message, channel);
        } else
            throw new MemberNotExistInChannelException();
    }
}
