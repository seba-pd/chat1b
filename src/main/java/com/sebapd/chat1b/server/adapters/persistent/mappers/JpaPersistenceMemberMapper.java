package com.sebapd.chat1b.server.adapters.persistent.mappers;

import com.sebapd.chat1b.server.adapters.persistent.entities.MemberEntity;
import com.sebapd.chat1b.server.domain.Member;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.util.UUID;

@Mapper(componentModel = "cdi", imports = {UUID.class, Instant.class})
public interface JpaPersistenceMemberMapper {

    MemberEntity toEntity(Member member);
    Member toDomain(MemberEntity memberEntity);
}
