package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.File;

import java.util.Optional;

public interface FileRepository {

    Optional<File> getFileByName(String name);
    void sendFile(File file, Channel channel);

    byte[] receiveContent(String fileLocation);
}
