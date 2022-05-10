package com.sebapd.chat1b.server.adapters.persistent.repositories;

import com.sebapd.chat1b.server.adapters.persistent.entities.MemberEntity;
import lombok.Setter;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;


public class JpaMemberRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private JpaChannelRepository jpaChannelRepository;

    public void save(MemberEntity memberEntity){
        entityManager.persist(memberEntity);
    }

    public void delete(String memberName) {
        var memberEntity = getByName(memberName);
        memberEntity.ifPresent(entity -> {
            entity.getChannelEntityList()
                    .forEach(c -> jpaChannelRepository.removeChannelMember(entity,c));
            entityManager.remove(entity);
        });
    }

    public Optional<MemberEntity> getByName(String name){
        try {
            return Optional.of((MemberEntity) entityManager.createQuery("select a From MemberEntity a where a.memberName like :name" )
                    .setParameter("name", name).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
