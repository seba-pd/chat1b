package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.domain.ChatMember;
import com.sebapd.chat1b.chat.domain.ChatMember.ChatMemberBuilder;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-26T18:16:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class JpaPersistenceChatMemberMapperImpl implements JpaPersistenceChatMemberMapper {

    @Override
    public ChatMemberEntity toEntity(ChatMember chatMember) {
        if ( chatMember == null ) {
            return null;
        }

        ChatMemberEntity chatMemberEntity = new ChatMemberEntity();

        chatMemberEntity.setName( chatMember.getName() );

        chatMemberEntity.setChatMemberId( UUID.randomUUID() );

        return chatMemberEntity;
    }

    @Override
    public ChatMember toDomain(ChatMemberEntity chatMemberEntity) {
        if ( chatMemberEntity == null ) {
            return null;
        }

        ChatMemberBuilder chatMember = ChatMember.builder();

        chatMember.name( chatMemberEntity.getName() );

        return chatMember.build();
    }
}
