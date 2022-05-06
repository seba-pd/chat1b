package com.sebapd.chat1b.server.domain.exceptions;

public class MemberAlreadyExistInChannelException extends RuntimeException{
    public MemberAlreadyExistInChannelException() {
        super("Member already exist in channel");
    }
}
