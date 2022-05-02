package com.sebapd.chat1b.chat.adapters.persistent.mappers;

import com.sebapd.chat1b.chat.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.chat.domain.Channel;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "cdi", imports = UUID.class)
public interface JpaPersistenceChannelMapper {

    Channel toDomain(ChannelEntity channelEntity);
    ChannelEntity toEntity(Channel channel);


}
