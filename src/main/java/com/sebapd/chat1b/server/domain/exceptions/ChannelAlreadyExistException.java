package com.sebapd.chat1b.server.domain.exceptions;

public class ChannelAlreadyExistException extends RuntimeException {
    public ChannelAlreadyExistException() {
        super("Channel already exist");
    }
}
