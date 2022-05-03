package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.File;

public interface FileService {

    void sendFile(String fileName, String authorName, byte[] content, String channelName);
    File getFileByName(String fileName, String memberName, String channelName);
}
