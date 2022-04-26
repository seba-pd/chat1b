package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.ports.FileRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChatFileService {

    private final FileRepository fileRepository;

    public byte[] receiveFile(String name) {
        return fileRepository.getFileByName(name);
    }

    public void sendFile(String name, byte[] byteArr) {
        fileRepository.sendFile(name, byteArr);
    }


}
