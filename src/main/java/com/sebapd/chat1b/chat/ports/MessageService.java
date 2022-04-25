package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.ChatMessage;

public interface MessageService {

    ChatMessage getById(Long id);

    void send(ChatMessage message);

}
