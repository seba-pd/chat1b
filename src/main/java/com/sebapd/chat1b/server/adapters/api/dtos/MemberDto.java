package com.sebapd.chat1b.server.adapters.api.dtos;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class MemberDto {

    private UUID memberId;
    private String memberName;
    private Timestamp createTime;
}
