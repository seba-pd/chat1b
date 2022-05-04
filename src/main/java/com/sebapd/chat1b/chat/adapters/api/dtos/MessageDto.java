package com.sebapd.chat1b.chat.adapters.api.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageDto {

    private String memberName;
    private String content;
    private String channel;
    private Timestamp createDate;
}
