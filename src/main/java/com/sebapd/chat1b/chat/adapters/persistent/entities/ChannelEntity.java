package com.sebapd.chat1b.chat.adapters.persistent.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "channel")
public class ChannelEntity {
    @Id
    @Column(name = "channel_id", nullable = false)
    private UUID channelId;
    @Column(name = "channel_name")
    private String channelName;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "channel_member",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<MemberEntity> channelMembers = new LinkedList<>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "channel_message",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private List<MessageEntity> messageList = new LinkedList<>();
}
