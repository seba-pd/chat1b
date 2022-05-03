package com.sebapd.chat1b.chat.adapters.api.dtos;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class FileDto {

    private UUID fileId;
    private String memberName;
    private String fileName;
    private String content;
    private String channelName;
    private Timestamp createTime;
}
