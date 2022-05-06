package com.sebapd.chat1b.server.domain.decorators;

import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.ports.JMSMessageService;
import com.sebapd.chat1b.server.ports.MessageService;
import lombok.Setter;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Setter
@Decorator
public abstract class JmsChatMessageServiceDecorator implements MessageService {

    @Delegate
    @Inject
    private MessageService messageService;
    @Inject
    private JMSMessageService jmsMessageService;

    @Override
    public void send(Message message, String channelName) {
        messageService.send(message, channelName);
        message.setChannelName(channelName);
        jmsMessageService.toBroker(message);
    }

}
