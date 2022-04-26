package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.domain.ChatMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "cdi", imports = UUID.class)
public interface JpaPersistenceChatMemberMapper {

    @Mapping(target = "chatMemberId", expression = "java(UUID.randomUUID())" )
    ChatMemberEntity toEntity(ChatMember chatMember);
    ChatMember toDomain(ChatMemberEntity chatMemberEntity);
}
