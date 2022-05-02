package com.sebapd.chat1b.chat.adapters.persistent.repositories;

import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

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

    public Optional<MemberEntity> getByName(String name){
        try {
            return Optional.of((MemberEntity) entityManager.createQuery("select a From MemberEntity a where a.name like :name" )
                    .setParameter("name", name).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
