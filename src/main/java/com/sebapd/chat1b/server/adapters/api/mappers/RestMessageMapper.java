package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.MessageDto;
import com.sebapd.chat1b.server.domain.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Mapper(componentModel = "cdi", imports = {Instant.class, UUID.class})
public interface RestMessageMapper {

    @Mapping(target = "createTime", expression = "java(java.sql.Timestamp.from(Instant.now()))")
    @Mapping(target = "messageId", expression = "java(java.util.UUID.randomUUID())")
    Message toDomain(MessageDto messageDto);
    MessageDto toDto(Message message);
}
