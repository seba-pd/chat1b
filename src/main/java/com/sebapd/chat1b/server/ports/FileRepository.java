package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.File;

import java.util.Optional;

public interface FileRepository {

    Optional<File> getFileByName(String name);
    void sendFile(File file, Channel channel);

    byte[] receiveContent(String fileLocation);
}
