package com.sebapd.chat1b.chat.adapters.persistent.mappers;

import com.sebapd.chat1b.chat.adapters.persistent.entities.MessageEntity;
import com.sebapd.chat1b.chat.domain.Message;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "cdi", imports = UUID.class)
public interface JpaPersistenceMessageMapper {

    Message toDomain(MessageEntity messageEntity);
    MessageEntity toEntity(Message message);


}
