package com.sebapd.chat1b.server.adapters.persistent.entities;

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
@Table(name = "member")
public class MemberEntity {
    @Id
    @Column(name = "member_id", nullable = false)
    private UUID memberId;
    @Column(name = "member_name" , nullable = false, unique = true)
    private String memberName;
    @Column(nullable = false)
    private Timestamp createTime;
    @ManyToMany(mappedBy = "channelMembers")
    private List<ChannelEntity> channelEntityList;

}
