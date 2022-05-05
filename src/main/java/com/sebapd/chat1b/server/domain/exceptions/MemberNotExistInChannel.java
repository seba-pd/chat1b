package com.sebapd.chat1b.server.domain.exceptions;

public class MemberNotExistInChannel extends RuntimeException{
    public MemberNotExistInChannel() {
        super("Member not exist in channel");
    }
}
