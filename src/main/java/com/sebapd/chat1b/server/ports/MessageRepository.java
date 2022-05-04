package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.Message;

public interface MessageRepository {

    void sendMessage(Message message, Channel channel);
}
