package com.sebapd.chat1b.server.adapters.persistent.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

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
    @ManyToMany
    @JoinTable(name = "channel_member",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<MemberEntity> channelMembers = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "channel_message",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private List<MessageEntity> messageList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "channel_file",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private List<FileEntity> fileList = new ArrayList<>();
}
