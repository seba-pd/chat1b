package com.sebapd.chat1b.server.adapters.persistent.mappers;

import com.sebapd.chat1b.server.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.server.domain.Channel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface JpaPersistenceChannelMapper {

    Channel toDomain(ChannelEntity channelEntity);
    ChannelEntity toEntity(Channel channel);


}
