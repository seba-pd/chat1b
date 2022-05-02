package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.Message;

public interface MessageRepository {

    void sendMessage(Message message, Channel channel);
}
