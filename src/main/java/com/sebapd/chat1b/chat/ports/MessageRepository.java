package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {

    void send(Message message, String channelName);

    Optional<Message> getById(Long id);

    List<Message> getMessages();
}
