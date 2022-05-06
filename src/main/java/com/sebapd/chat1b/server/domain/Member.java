package com.sebapd.chat1b.server.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Getter
@EqualsAndHashCode
public class Member {

    private UUID memberId;
    private String memberName;
    private Timestamp createDate;
}
