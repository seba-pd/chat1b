package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.MessageDto;
import com.sebapd.chat1b.server.domain.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RestMessageMapper {

    Message toDomain(MessageDto messageDto);
    MessageDto toDto(Message message);
}
