package com.sebapd.chat1b.server.adapters.api.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageDto {

    private String memberName;
    private String content;
    private String channelName;
    private Timestamp createTime;
}
