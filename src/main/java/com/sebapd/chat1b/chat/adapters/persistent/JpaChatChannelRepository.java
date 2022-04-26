package com.sebapd.chat1b.chat.adapters.persistent;

import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaChatChannelRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;


}
