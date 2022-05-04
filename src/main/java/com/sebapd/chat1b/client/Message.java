package com.sebapd.chat1b.client;

import lombok.Data;

@Data
public class Message {

    private String content;
    private String memberName;
    private String createTime;
}
