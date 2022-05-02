package com.sebapd.chat1b.chat.adapters.persistent.repositories;

import com.sebapd.chat1b.chat.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaChannelRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    public void addChannelMember(MemberEntity memberEntity, ChannelEntity channelEntity){
        channelEntity.getChannelMembers().add(memberEntity);
        entityManager.merge(channelEntity);
    }

    public void removeChannelMember(MemberEntity memberEntity, ChannelEntity channelEntity){
        channelEntity.getChannelMembers().remove(memberEntity);
        entityManager.merge(channelEntity);
    }

    public List<MemberEntity> getChannelMembers(ChannelEntity channelEntity){
        TypedQuery<MemberEntity> query = entityManager.createQuery("select MemberEntity From ChannelEntity WHERE ChannelEntity.channelName like :" + channelEntity.getChannelName(), MemberEntity.class);
        return query.getResultList();
    }


}
