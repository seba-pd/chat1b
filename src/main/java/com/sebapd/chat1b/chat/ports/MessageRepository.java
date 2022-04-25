package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.ChatMessage;

import java.util.Optional;

public interface MessageRepository {

    void send(ChatMessage message);

    Optional<ChatMessage> getById(Long id);
}
