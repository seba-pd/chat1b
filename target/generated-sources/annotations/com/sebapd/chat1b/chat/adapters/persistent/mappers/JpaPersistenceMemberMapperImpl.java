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
    date = "2022-05-01T19:11:25+0200",
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
        memberEntity.setActiveChannels( channelListToChannelEntityList( member.getActiveChannels() ) );

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
        member.activeChannels( channelEntityListToChannelList( memberEntity.getActiveChannels() ) );

        return member.build();
    }

    protected List<MemberEntity> memberListToMemberEntityList(List<Member> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberEntity> list1 = new ArrayList<MemberEntity>( list.size() );
        for ( Member member : list ) {
            list1.add( toEntity( member ) );
        }

        return list1;
    }

    protected ChannelEntity channelToChannelEntity(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        ChannelEntity channelEntity = new ChannelEntity();

        channelEntity.setId( channel.getId() );
        channelEntity.setChannelName( channel.getChannelName() );
        channelEntity.setChannelMembers( memberListToMemberEntityList( channel.getChannelMembers() ) );

        return channelEntity;
    }

    protected List<ChannelEntity> channelListToChannelEntityList(List<Channel> list) {
        if ( list == null ) {
            return null;
        }

        List<ChannelEntity> list1 = new ArrayList<ChannelEntity>( list.size() );
        for ( Channel channel : list ) {
            list1.add( channelToChannelEntity( channel ) );
        }

        return list1;
    }

    protected List<Member> memberEntityListToMemberList(List<MemberEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Member> list1 = new ArrayList<Member>( list.size() );
        for ( MemberEntity memberEntity : list ) {
            list1.add( toDomain( memberEntity ) );
        }

        return list1;
    }

    protected Channel channelEntityToChannel(ChannelEntity channelEntity) {
        if ( channelEntity == null ) {
            return null;
        }

        ChannelBuilder channel = Channel.builder();

        channel.id( channelEntity.getId() );
        channel.channelMembers( memberEntityListToMemberList( channelEntity.getChannelMembers() ) );
        channel.channelName( channelEntity.getChannelName() );

        return channel.build();
    }

    protected List<Channel> channelEntityListToChannelList(List<ChannelEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Channel> list1 = new ArrayList<Channel>( list.size() );
        for ( ChannelEntity channelEntity : list ) {
            list1.add( channelEntityToChannel( channelEntity ) );
        }

        return list1;
    }
}
