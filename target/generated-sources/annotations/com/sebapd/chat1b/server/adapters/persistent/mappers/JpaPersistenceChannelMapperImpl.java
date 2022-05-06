package com.sebapd.chat1b.server.adapters.persistent.mappers;

import com.sebapd.chat1b.server.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.server.adapters.persistent.entities.MemberEntity;
import com.sebapd.chat1b.server.adapters.persistent.entities.MessageEntity;
import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.Channel.ChannelBuilder;
import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.Member.MemberBuilder;
import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.domain.Message.MessageBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-06T22:52:43+0200",
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
        channel.messageList( messageEntityListToMessageList( channelEntity.getMessageList() ) );

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
        channelEntity.setMessageList( messageListToMessageEntityList( channel.getMessageList() ) );

        return channelEntity;
    }

    protected Member memberEntityToMember(MemberEntity memberEntity) {
        if ( memberEntity == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.memberId( memberEntity.getMemberId() );
        member.memberName( memberEntity.getMemberName() );

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

    protected Message messageEntityToMessage(MessageEntity messageEntity) {
        if ( messageEntity == null ) {
            return null;
        }

        MessageBuilder message = Message.builder();

        message.messageId( messageEntity.getMessageId() );
        message.memberName( messageEntity.getMemberName() );
        message.content( messageEntity.getContent() );
        message.createTime( messageEntity.getCreateTime() );
        List<String> list = messageEntity.getAccessMembersList();
        if ( list != null ) {
            message.accessMembersList( new ArrayList<String>( list ) );
        }

        return message.build();
    }

    protected List<Message> messageEntityListToMessageList(List<MessageEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Message> list1 = new ArrayList<Message>( list.size() );
        for ( MessageEntity messageEntity : list ) {
            list1.add( messageEntityToMessage( messageEntity ) );
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

    protected MessageEntity messageToMessageEntity(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageEntity messageEntity = new MessageEntity();

        messageEntity.setMessageId( message.getMessageId() );
        messageEntity.setMemberName( message.getMemberName() );
        messageEntity.setContent( message.getContent() );
        messageEntity.setCreateTime( message.getCreateTime() );
        List<String> list = message.getAccessMembersList();
        if ( list != null ) {
            messageEntity.setAccessMembersList( new ArrayList<String>( list ) );
        }

        return messageEntity;
    }

    protected List<MessageEntity> messageListToMessageEntityList(List<Message> list) {
        if ( list == null ) {
            return null;
        }

        List<MessageEntity> list1 = new ArrayList<MessageEntity>( list.size() );
        for ( Message message : list ) {
            list1.add( messageToMessageEntity( message ) );
        }

        return list1;
    }
}
