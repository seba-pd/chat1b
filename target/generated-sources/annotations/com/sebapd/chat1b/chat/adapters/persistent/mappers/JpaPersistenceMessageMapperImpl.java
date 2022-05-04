package com.sebapd.chat1b.chat.adapters.persistent.mappers;

import com.sebapd.chat1b.chat.adapters.persistent.entities.MessageEntity;
import com.sebapd.chat1b.chat.domain.Message;
import com.sebapd.chat1b.chat.domain.Message.MessageBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-04T13:26:47+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class JpaPersistenceMessageMapperImpl implements JpaPersistenceMessageMapper {

    @Override
    public Message toDomain(MessageEntity messageEntity) {
        if ( messageEntity == null ) {
            return null;
        }

        MessageBuilder message = Message.builder();

        message.messageId( messageEntity.getMessageId() );
        message.memberName( messageEntity.getMemberName() );
        message.content( messageEntity.getContent() );
        message.createDate( messageEntity.getCreateDate() );
        List<String> list = messageEntity.getAccessMembersList();
        if ( list != null ) {
            message.accessMembersList( new ArrayList<String>( list ) );
        }

        return message.build();
    }

    @Override
    public MessageEntity toEntity(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageEntity messageEntity = new MessageEntity();

        messageEntity.setMessageId( message.getMessageId() );
        messageEntity.setMemberName( message.getMemberName() );
        messageEntity.setContent( message.getContent() );
        messageEntity.setCreateDate( message.getCreateDate() );
        List<String> list = message.getAccessMembersList();
        if ( list != null ) {
            messageEntity.setAccessMembersList( new ArrayList<String>( list ) );
        }

        return messageEntity;
    }
}
