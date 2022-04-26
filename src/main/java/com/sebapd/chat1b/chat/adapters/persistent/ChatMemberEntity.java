package com.sebapd.chat1b.chat.adapters.persistent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@EqualsAndHashCode
@Entity
@Setter
@Getter
public class ChatMemberEntity {
    @Id
    @Column(name = "chat_member_id", nullable = false)
    private UUID chatMemberId;
    @Column(nullable = false, unique = true)
    private String name;


}
