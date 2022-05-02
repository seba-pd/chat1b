package com.sebapd.chat1b.chat.adapters.api.mappers;

import com.sebapd.chat1b.chat.adapters.api.dtos.MemberDto;
import com.sebapd.chat1b.chat.domain.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RestMemberMapper {

    Member toDomain(MemberDto memberDto);
    MemberDto toDto(Member member);
}
