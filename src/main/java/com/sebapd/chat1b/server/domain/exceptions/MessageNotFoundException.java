package com.sebapd.chat1b.server.domain.exceptions;

public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException() {
        super("Message not found");
    }
}
