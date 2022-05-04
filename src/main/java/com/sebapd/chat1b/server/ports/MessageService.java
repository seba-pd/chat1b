package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.Message;

public interface MessageService {

    void send(Message message, String channelName);

}
