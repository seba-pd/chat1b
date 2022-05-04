package com.sebapd.chat1b.chat.adapters.persistent.repositories;

import com.sebapd.chat1b.chat.adapters.persistent.entities.ChannelEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


public class JpaChannelsRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    public void addChannel(ChannelEntity channelEntity) {
        entityManager.persist(channelEntity);
    }

    public void deleteChannel(String channelName) {
        var channel = getByName(channelName).get();
        entityManager.remove(channel);
    }

    public List<ChannelEntity> getChannels() {
        TypedQuery<ChannelEntity> query = entityManager.createQuery("select c from ChannelEntity c", ChannelEntity.class);
        return query.getResultList();
    }

    public Optional<ChannelEntity> getByName(String name) {
        try {
            return Optional.of((ChannelEntity) entityManager.createQuery("select a From ChannelEntity a where a.channelName like :name")
                    .setParameter("name", name).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
