package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.MemberDto;
import com.sebapd.chat1b.server.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.util.UUID;

@Mapper(componentModel = "cdi", imports = {Instant.class, UUID.class})
public interface RestMemberMapper {

    @Mapping(target = "createTime", expression = "java(java.sql.Timestamp.from(Instant.now()))")
    @Mapping(target = "memberId", expression = "java(java.util.UUID.randomUUID())")
    Member toDomain(MemberDto memberDto);
}
