package com.sebapd.chat1b.chat.ports;

public interface FileRepository {

    byte[] getFileByName(String name);
    void sendFile(String name, byte [] byteArr);
}
