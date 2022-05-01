package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.Message;
import com.sebapd.chat1b.chat.ports.MessageRepository;
import com.sebapd.chat1b.chat.ports.MessageService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChatMessageService implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public void send(Message message, String channelName) {
        messageRepository.send(message, channelName);
    }
}
