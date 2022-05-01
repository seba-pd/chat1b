package com.sebapd.chat1b.chat.adapters.persistent.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Entity
@Setter
@Getter
public class MemberEntity {
    @Id
    @Column(name = "member_id", nullable = false)
    private UUID memberId;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private Timestamp createDate;
    @ManyToMany
    @JoinTable(
            name = "member_channel",
            joinColumns = @JoinColumn(name = "Member_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id")
    )
    private List<ChannelEntity> activeChannels;

    public void addChannel(ChannelEntity channelEntity){
        this.activeChannels.add(channelEntity);
        channelEntity.getChannelMembers().add(this);
    }

    public void removeChannel(ChannelEntity channelEntity){
        this.activeChannels.remove(channelEntity);
        channelEntity.getChannelMembers().remove(this);
    }

}
