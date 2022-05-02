package com.sebapd.chat1b.chat.adapters.api.mappers;

import com.sebapd.chat1b.chat.adapters.api.dtos.MessageDto;
import com.sebapd.chat1b.chat.domain.Message;
import com.sebapd.chat1b.chat.domain.Message.MessageBuilder;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-02T23:16:44+0200",
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

        message.author( messageDto.getAuthor() );
        message.content( messageDto.getContent() );

        return message.build();
    }

    @Override
    public MessageDto toDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setAuthor( message.getAuthor() );
        messageDto.setContent( message.getContent() );

        return messageDto;
    }
}
