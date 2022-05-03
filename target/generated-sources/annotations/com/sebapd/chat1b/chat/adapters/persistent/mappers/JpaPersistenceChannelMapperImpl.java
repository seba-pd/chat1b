package com.sebapd.chat1b.chat.adapters.persistent.mappers;

import com.sebapd.chat1b.chat.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.Channel.ChannelBuilder;
import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.domain.Member.MemberBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T15:06:11+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class JpaPersistenceChannelMapperImpl implements JpaPersistenceChannelMapper {

    @Override
    public Channel toDomain(ChannelEntity channelEntity) {
        if ( channelEntity == null ) {
            return null;
        }

        ChannelBuilder channel = Channel.builder();

        channel.channelId( channelEntity.getChannelId() );
        channel.channelMembers( memberEntityListToMemberList( channelEntity.getChannelMembers() ) );
        channel.channelName( channelEntity.getChannelName() );

        return channel.build();
    }

    @Override
    public ChannelEntity toEntity(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        ChannelEntity channelEntity = new ChannelEntity();

        channelEntity.setChannelId( channel.getChannelId() );
        channelEntity.setChannelName( channel.getChannelName() );
        channelEntity.setChannelMembers( memberListToMemberEntityList( channel.getChannelMembers() ) );

        return channelEntity;
    }

    protected Member memberEntityToMember(MemberEntity memberEntity) {
        if ( memberEntity == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.memberId( memberEntity.getMemberId() );
        member.memberName( memberEntity.getMemberName() );
        member.createDate( memberEntity.getCreateDate() );

        return member.build();
    }

    protected List<Member> memberEntityListToMemberList(List<MemberEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Member> list1 = new ArrayList<Member>( list.size() );
        for ( MemberEntity memberEntity : list ) {
            list1.add( memberEntityToMember( memberEntity ) );
        }

        return list1;
    }

    protected MemberEntity memberToMemberEntity(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setMemberId( member.getMemberId() );
        memberEntity.setMemberName( member.getMemberName() );
        memberEntity.setCreateDate( member.getCreateDate() );

        return memberEntity;
    }

    protected List<MemberEntity> memberListToMemberEntityList(List<Member> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberEntity> list1 = new ArrayList<MemberEntity>( list.size() );
        for ( Member member : list ) {
            list1.add( memberToMemberEntity( member ) );
        }

        return list1;
    }
}
