package com.sebapd.chat1b.chat.adapters.api.dtos;

import lombok.Data;

@Data
public class AddMemberToChannelDto {

    private String memberName;
    private String channelName;
}
