package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Message;

public interface MessageService {

    void send(Message message, String channelName);

}
