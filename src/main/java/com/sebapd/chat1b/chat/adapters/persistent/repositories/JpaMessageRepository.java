package com.sebapd.chat1b.chat.adapters.persistent.repositories;

import com.sebapd.chat1b.chat.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.chat.adapters.persistent.entities.MessageEntity;
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
