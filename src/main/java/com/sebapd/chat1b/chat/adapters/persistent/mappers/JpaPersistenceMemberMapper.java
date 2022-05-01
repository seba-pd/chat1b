package com.sebapd.chat1b.chat.adapters.persistent.mappers;

import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import com.sebapd.chat1b.chat.domain.Member;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "cdi", imports = UUID.class)
public interface JpaPersistenceMemberMapper {

    MemberEntity toEntity(Member member);
    Member toDomain(MemberEntity memberEntity);
}
