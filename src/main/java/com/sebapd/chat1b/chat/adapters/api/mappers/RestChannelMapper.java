package com.sebapd.chat1b.chat.adapters.api.mappers;

import com.sebapd.chat1b.chat.adapters.api.dtos.ChannelDto;
import com.sebapd.chat1b.chat.domain.Channel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RestChannelMapper {

    ChannelDto toDto(Channel channel);
    Channel toDomain(ChannelDto channelDto);

}
