package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.ChatMessage;

public interface MessageService {

    void send(ChatMessage message, String channelName);

}
