package com.sebapd.chat1b.chat.adapters.persistent.mappers;

import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.domain.Member.MemberBuilder;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-02T23:16:44+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class JpaPersistenceMemberMapperImpl implements JpaPersistenceMemberMapper {

    @Override
    public MemberEntity toEntity(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setMemberId( member.getMemberId() );
        memberEntity.setName( member.getName() );
        memberEntity.setCreateDate( member.getCreateDate() );

        return memberEntity;
    }

    @Override
    public Member toDomain(MemberEntity memberEntity) {
        if ( memberEntity == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.memberId( memberEntity.getMemberId() );
        member.name( memberEntity.getName() );
        member.createDate( memberEntity.getCreateDate() );

        return member.build();
    }
}
