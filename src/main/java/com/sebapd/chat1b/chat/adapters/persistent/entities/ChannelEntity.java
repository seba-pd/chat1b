package com.sebapd.chat1b.chat.adapters.persistent.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@EqualsAndHashCode
@Getter
@Setter
public class ChannelEntity {
    @Id
    @Column(name = "channel_id", nullable = false)
    private UUID id;
    @Column(name = "channel_name")
    private String channelName;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "activeChannels")
    private List<MemberEntity> channelMembers;
}
