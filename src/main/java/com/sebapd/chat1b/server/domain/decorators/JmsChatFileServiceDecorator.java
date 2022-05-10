package com.sebapd.chat1b.server.domain.decorators;

import com.sebapd.chat1b.server.domain.File;
import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.ports.FileService;
import com.sebapd.chat1b.server.ports.JMSMessageService;
import lombok.Setter;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
@Setter
public abstract class JmsChatFileServiceDecorator implements FileService {

    @Delegate
    @Inject
    private FileService fileService;
    @Inject
    private JMSMessageService jmsMessageService;


    @Override
    public void saveFile(File file) {
        fileService.saveFile(file);
        var message = Message.builder()
                .memberName(file.getMemberName())
                .createTime(file.getCreateTime())
                .content("send a file : " + file.getFileName())
                .channelName(file.getChannelName())
                .build();
        jmsMessageService.toBroker(message);
    }
}
