package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.MemberDto;
import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.Member.MemberBuilder;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-06T18:33:14+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class RestMemberMapperImpl implements RestMemberMapper {

    @Override
    public Member toDomain(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.memberName( memberDto.getMemberName() );

        return member.build();
    }

    @Override
    public MemberDto toDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDto memberDto = new MemberDto();

        memberDto.setMemberName( member.getMemberName() );

        return memberDto;
    }
}
