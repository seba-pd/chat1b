package com.sebapd.chat1b.server.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
public class Message implements Serializable {

    @Setter
    private UUID messageId;
    private String memberName;
    private String content;
    @Setter
    private String channelName;
    private Timestamp createTime;
    private List<String> accessMembersList;

    public String messageToString() {
        return
                "memberName='" + memberName + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createTime;
    }
}
