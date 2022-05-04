package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.ChannelDto;
import com.sebapd.chat1b.server.domain.Channel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RestChannelMapper {

    ChannelDto toDto(Channel channel);
    Channel toDomain(ChannelDto channelDto);

}
