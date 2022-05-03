package com.sebapd.chat1b.chat.adapters.api.dtos;

import lombok.Data;

@Data
public class MessageDto {

    private String memberName;
    private String content;
    private String toChannel;
}
