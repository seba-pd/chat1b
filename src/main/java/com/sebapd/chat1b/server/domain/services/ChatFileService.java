package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.File;
import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.FileNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotExistInChannel;
import com.sebapd.chat1b.server.ports.*;
import com.sebapd.chat1b.server.ports.ChannelsRepository;
import com.sebapd.chat1b.server.ports.FileRepository;
import com.sebapd.chat1b.server.ports.FileService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatFileService implements FileService {

    private final FileRepository fileRepository;
    private final ChannelsRepository channelsRepository;
    private final JMSMessageService jmsMessageService;

    @Override
    public void sendFile(String fileName, String memberName, byte[] content, String channelName) {
        toDatabase(fileName, memberName, content, channelName);
        var message = Message.builder()
                .memberName(memberName)
                .createTime(Timestamp.from(Instant.now()))
                .content("send a file : " + fileName)
                .build();
        jmsMessageService.toBroker(message,channelName);

    }

    @Override
    public File getFileByName(String fileName, String memberName, String channelName) {
        var file = fileRepository.getFileByName(fileName)
                .orElseThrow(FileNotFoundException::new);
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        if (ifMemberExistOnChannel(channel, memberName))
            file.setContent(fileRepository.receiveContent(file.getContentLocation()));
        return file;
    }

    private void toDatabase(String fileName, String memberName, byte[] content, String channelName) {
        var file = File.builder()
                .fileId(UUID.randomUUID())
                .fileName(fileName)
                .memberName(memberName)
                .content(content)
                .createTime(Timestamp.from(Instant.now()))
                .build();

        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        if (ifMemberExistOnChannel(channel, memberName)) {
            fileRepository.sendFile(file, channel);
        } else
            throw new MemberNotExistInChannel();
    }

    private boolean ifMemberExistOnChannel(Channel channel, String memberName) {
        var membersNames = channel.getChannelMembers()
                .stream()
                .map(Member::getMemberName)
                .toList();
        return membersNames.contains(memberName);
    }
}
