package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.ChatMessage;
import com.sebapd.chat1b.chat.ports.HistoryService;
import com.sebapd.chat1b.chat.ports.MessageRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ChatHistoryService implements HistoryService {

    private final MessageRepository messageRepository;

    @Override
    public List<ChatMessage> getChannelHistory(String channelName) {
        return messageRepository.getMessages();
    }
}
