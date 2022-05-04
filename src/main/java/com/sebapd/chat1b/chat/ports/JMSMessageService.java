package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Message;

public interface JMSMessageService {

    void toBroker(Message message, String channelName);

}
