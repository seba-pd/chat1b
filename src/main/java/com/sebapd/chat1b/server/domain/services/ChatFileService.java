package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.File;
import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.FileNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.FileOrMemberNotExistInChannelException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotExistInChannelException;
import com.sebapd.chat1b.server.ports.ChannelsRepository;
import com.sebapd.chat1b.server.ports.FileRepository;
import com.sebapd.chat1b.server.ports.FileService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatFileService implements FileService {

    private final FileRepository fileRepository;
    private final ChannelsRepository channelsRepository;

    @Override
    public void saveFile(File file) {
        var channel = channelsRepository.getChannelByName(file.getChannelName())
                .orElseThrow(ChannelNotFoundException::new);
        if (ifMemberExistOnChannel(channel, file.getMemberName())) {
            fileRepository.sendFile(file, channel);
        } else
            throw new MemberNotExistInChannelException();
    }

    @Override
    public File getFileByName(String fileName, String memberName, String channelName) {
        var channel = channelsRepository.getChannelByName(channelName)
                .orElseThrow(ChannelNotFoundException::new);
        var file = fileRepository.getFileByName(fileName)
                .orElseThrow(FileNotFoundException::new);
        if (ifMemberExistOnChannel(channel, memberName) && ifFileExistOnChannel(channel,fileName)) {
            file.setContent(fileRepository.receiveContent(file.getContentLocation()));
            return file;
        }else throw new FileOrMemberNotExistInChannelException();
    }

    private boolean ifMemberExistOnChannel(Channel channel, String memberName) {
        var membersNames = channel.getChannelMembers()
                .stream()
                .map(Member::getMemberName)
                .toList();
        return membersNames.contains(memberName);
    }

    private boolean ifFileExistOnChannel(Channel channel, String fileName){
        var fileNames = channel.getFileList()
                .stream()
                .map(File::getFileName)
                .toList();
        return fileNames.contains(fileName);
    }
}
