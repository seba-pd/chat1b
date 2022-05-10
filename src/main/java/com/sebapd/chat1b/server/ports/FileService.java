package com.sebapd.chat1b.server.ports;

import com.sebapd.chat1b.server.domain.File;

public interface FileService {

    void saveFile(File file);

    File getFileByName(String fileName, String memberName, String channelName);
}
