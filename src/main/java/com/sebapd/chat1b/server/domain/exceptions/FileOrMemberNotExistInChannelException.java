package com.sebapd.chat1b.server.domain.exceptions;

public class FileOrMemberNotExistInChannelException extends RuntimeException {
    public FileOrMemberNotExistInChannelException() {
        super("File or member not exist in channel");
    }
}
