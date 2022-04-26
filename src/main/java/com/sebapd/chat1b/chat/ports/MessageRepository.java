package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.ChatMessage;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {

    void send(ChatMessage message, String channelName);

    Optional<ChatMessage> getById(Long id);

    List<ChatMessage> getMessages();
}
