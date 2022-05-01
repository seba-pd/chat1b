package com.sebapd.chat1b.chat.adapters.persistent.repositories;

import com.sebapd.chat1b.chat.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class JpaChannelsRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    public void addChannel(ChannelEntity channelEntity) {
        entityManager.persist(channelEntity);
    }

    public void deleteChannel(ChannelEntity channelEntity) {
        entityManager.remove(channelEntity);
    }

    public List<ChannelEntity> getChannels() {
        TypedQuery<ChannelEntity> query = entityManager.createQuery("select c from ChannelEntity c", ChannelEntity.class);
        return query.getResultList();
    }

    public ChannelEntity getByName(String name) {
        return (ChannelEntity) entityManager.createQuery("select a From ChannelEntity a where a.channelName like :name")
                .setParameter("name", name).getSingleResult();
    }
}
