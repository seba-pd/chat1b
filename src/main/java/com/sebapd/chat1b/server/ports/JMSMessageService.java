package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.Message;

public interface JMSMessageService {

    void toBroker(Message message);

}
