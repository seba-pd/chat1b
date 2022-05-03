package com.sebapd.chat1b.chat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Getter
public class File {

    private UUID fileId;
    private String author;
    private String fileName;
    private String contentLocation;
    @Setter
    private byte[] content;
    private Timestamp createTime;
}
