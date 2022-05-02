package com.sebapd.chat1b.chat.adapters.api.dtos;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ChannelDto {

    private UUID channelId;
    private String channelName;
    private List<MemberDto> channelMembers;
}
