package com.sebapd.chat1b.server.adapters.api.dtos;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ChannelDto {

    private UUID channelId;
    private String channelName;
    private List<MemberDto> channelMembers;
}
