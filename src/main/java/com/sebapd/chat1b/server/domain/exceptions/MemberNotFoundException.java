package com.sebapd.chat1b.server.domain.exceptions;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException() {
        super("Member not found");
    }
}
