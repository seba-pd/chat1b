package com.sebapd.chat1b.chat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
public class Message {

    @Setter
    private UUID messageId;
    private String memberName;
    private String content;
    @Setter
    private Timestamp createDate;
    private List<String> accessMembersList;

}
