package com.sebapd.chat1b.server.adapters.persistent.repositories;

import com.sebapd.chat1b.server.adapters.persistent.entities.MessageEntity;
import com.sebapd.chat1b.server.adapters.persistent.entities.ChannelEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaMessageRepository {

    @Setter
    @PersistenceContext
    EntityManager entityManager;

    public void sendMessage(MessageEntity messageEntity, ChannelEntity channelEntity){
        entityManager.persist(messageEntity);
        channelEntity.getMessageList().add(messageEntity);
        entityManager.merge(channelEntity);
    }
}
