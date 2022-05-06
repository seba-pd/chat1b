package com.sebapd.chat1b.server.domain.exceptions;

public class MemberNotExistInChannelException extends RuntimeException{
    public MemberNotExistInChannelException() {
        super("Member not exist in channel");
    }
}
