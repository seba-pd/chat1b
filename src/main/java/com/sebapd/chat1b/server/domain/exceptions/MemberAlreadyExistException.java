package com.sebapd.chat1b.server.domain.exceptions;

public class MemberAlreadyExistException extends RuntimeException{
    public MemberAlreadyExistException() {
        super("Member already exist");
    }
}
