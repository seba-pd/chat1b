package com.sebapd.chat1b.server.adapters.persistent.mappers;

import com.sebapd.chat1b.server.adapters.persistent.entities.MemberEntity;
import com.sebapd.chat1b.server.domain.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface JpaPersistenceMemberMapper {

    MemberEntity toEntity(Member member);
    Member toDomain(MemberEntity memberEntity);
}
