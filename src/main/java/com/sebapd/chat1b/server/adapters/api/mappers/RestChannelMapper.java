package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.ChannelDto;
import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Instant;
import java.util.Base64;
import java.util.LinkedList;
import java.util.UUID;

@Mapper(componentModel = "cdi", imports = { UUID.class})
public interface RestChannelMapper {

    ChannelDto toDto(Channel channel);
    @Mapping(target = "channelId", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "channelMembers", qualifiedByName = "newLinkedArray")
    Channel toDomain(ChannelDto channelDto);

    @Named("newLinkedArray")
    static LinkedList<Member> newLinkedList(){
        return new LinkedList<>();
    }

}
