package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.File;
import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.chat.domain.exceptions.FileNotFoundException;
import com.sebapd.chat1b.chat.domain.exceptions.MemberNotExistInChannel;
import com.sebapd.chat1b.chat.domain.exceptions.MemberNotFoundException;
import com.sebapd.chat1b.chat.ports.*;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatFileService implements FileService {

    private final FileRepository fileRepository;
    private final ChannelsRepository channelsRepository;

    @Override
    public void sendFile(String fileName, String memberName, byte[] content, String channelName) {
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

    private boolean ifMemberExistOnChannel(Channel channel, String memberName) {
        var membersNames = channel.getChannelMembers()
                .stream()
                .map(Member::getMemberName)
                .toList();
        return membersNames.contains(memberName);
    }
}
