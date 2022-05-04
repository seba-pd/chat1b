package com.sebapd.chat1b.chat.adapters.persistent.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Entity
@Setter
@Getter
@Table(name = "message")
public class MessageEntity {

    @Id
    @Column(name = "message_id", nullable = false)
    private UUID messageId;
    @Column(name = "member_name", nullable = false)
    private String memberName;
    @Column(name = "content")
    private String content;
    @Column(name = "create_date", nullable = false)
    private Timestamp createDate;
    @ElementCollection
    private List<String> accessMembersList = new ArrayList<>();

}
