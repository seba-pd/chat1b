package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.MessageDto;
import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.domain.Message.MessageBuilder;
import java.time.Instant;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-10T17:23:15+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class RestMessageMapperImpl implements RestMessageMapper {

    @Override
    public Message toDomain(MessageDto messageDto) {
        if ( messageDto == null ) {
            return null;
        }

        MessageBuilder message = Message.builder();

        message.memberName( messageDto.getMemberName() );
        message.content( messageDto.getContent() );
        message.channelName( messageDto.getChannelName() );

        message.createTime( java.sql.Timestamp.from(Instant.now()) );
        message.messageId( java.util.UUID.randomUUID() );

        return message.build();
    }

    @Override
    public MessageDto toDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setMemberName( message.getMemberName() );
        messageDto.setContent( message.getContent() );
        messageDto.setChannelName( message.getChannelName() );
        messageDto.setCreateTime( message.getCreateTime() );

        return messageDto;
    }
}
