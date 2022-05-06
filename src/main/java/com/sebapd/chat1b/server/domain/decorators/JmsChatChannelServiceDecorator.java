package com.sebapd.chat1b.server.domain.decorators;

import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.ports.ChannelService;
import com.sebapd.chat1b.server.ports.JMSMessageService;
import lombok.Setter;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;

@Setter
@Decorator
public abstract class JmsChatChannelServiceDecorator implements ChannelService {

    @Delegate
    @Inject
    private ChannelService channelService;
    @Inject
    private JMSMessageService jmsMessageService;

    @Override
    public void addMemberToChannel(String memberName, String channelName) {
        channelService.addMemberToChannel(memberName, channelName);
        jmsMessageService.toBroker(Message.builder()
                .content(" join to channel")
                .channelName(channelName)
                .memberName(memberName)
                .createTime(Timestamp.from(Instant.now()))
                .build());
    }

    @Override
    public void removeChannelMember(String memberName, String channelName) {
        channelService.removeChannelMember(memberName, channelName);
        jmsMessageService.toBroker(Message.builder()
                .content(memberName + " left from channel")
                .channelName(channelName)
                .memberName(memberName)
                .createTime(Timestamp.from(Instant.now()))
                .build());
    }
}
