package com.sebapd.chat1b.server.domain.exceptions;

public class ChannelNotFoundException extends RuntimeException{
    public ChannelNotFoundException() {
        super("Channel not found");
    }
}
