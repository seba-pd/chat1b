package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.ChannelDto;
import com.sebapd.chat1b.server.adapters.api.dtos.MemberDto;
import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.Channel.ChannelBuilder;
import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.Member.MemberBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T00:20:23+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class RestChannelMapperImpl implements RestChannelMapper {

    @Override
    public ChannelDto toDto(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        ChannelDto channelDto = new ChannelDto();

        channelDto.setChannelId( channel.getChannelId() );
        channelDto.setChannelName( channel.getChannelName() );
        channelDto.setChannelMembers( memberListToMemberDtoList( channel.getChannelMembers() ) );

        return channelDto;
    }

    @Override
    public Channel toDomain(ChannelDto channelDto) {
        if ( channelDto == null ) {
            return null;
        }

        ChannelBuilder channel = Channel.builder();

        channel.channelId( channelDto.getChannelId() );
        channel.channelMembers( memberDtoListToMemberList( channelDto.getChannelMembers() ) );
        channel.channelName( channelDto.getChannelName() );

        return channel.build();
    }

    protected MemberDto memberToMemberDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDto memberDto = new MemberDto();

        memberDto.setMemberId( member.getMemberId() );
        memberDto.setMemberName( member.getMemberName() );
        memberDto.setCreateTime( member.getCreateTime() );

        return memberDto;
    }

    protected List<MemberDto> memberListToMemberDtoList(List<Member> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberDto> list1 = new ArrayList<MemberDto>( list.size() );
        for ( Member member : list ) {
            list1.add( memberToMemberDto( member ) );
        }

        return list1;
    }

    protected Member memberDtoToMember(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.memberId( memberDto.getMemberId() );
        member.memberName( memberDto.getMemberName() );
        member.createTime( memberDto.getCreateTime() );

        return member.build();
    }

    protected List<Member> memberDtoListToMemberList(List<MemberDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Member> list1 = new ArrayList<Member>( list.size() );
        for ( MemberDto memberDto : list ) {
            list1.add( memberDtoToMember( memberDto ) );
        }

        return list1;
    }
}
