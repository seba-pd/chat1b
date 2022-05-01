package com.sebapd.chat1b.chat.adapters.persistent.repositories;

import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaMemberRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    public void save(MemberEntity memberEntity){
        entityManager.persist(memberEntity);
    }

    public void delete(String chatMemberName){
        entityManager.remove(getByName(chatMemberName));
    }

    public MemberEntity getByName(String name){
        return (MemberEntity) entityManager.createQuery("select a From MemberEntity a where a.name like :name" )
                .setParameter("name", name).getSingleResult();
    }
}
