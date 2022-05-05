package com.sebapd.chat1b.server.domain.exceptions;

public class FileNotFoundException extends RuntimeException{
    public FileNotFoundException() {
        super("File not found");
    }
}
