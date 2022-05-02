package com.sebapd.chat1b.chat.domain;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Getter
public class Member {

    private UUID memberId;
    private String name;
    private Timestamp createDate;
}
