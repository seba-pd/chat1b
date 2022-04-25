package com.sebapd.chat1b.chat.domain;

import com.sebapd.chat1b.chat.ports.MessageRepository;
import com.sebapd.chat1b.chat.ports.MessageService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChatMessageService implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public ChatMessage getById(Long id) {
        return messageRepository.getById(id)
                .orElseThrow(MessageNotFoundException::new);
    }

    @Override
    public void send(ChatMessage message) {
         messageRepository.send(message);
    }
}
