package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceMemberMapper;
import com.sebapd.chat1b.chat.adapters.persistent.repositories.JpaMemberRepository;
import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.ports.MemberRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Transactional
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject )
public class JpaMemberRepositoryAdapter implements MemberRepository {

    private final JpaPersistenceMemberMapper jpaPersistenceMemberMapper;
    private final JpaMemberRepository jpaMemberRepository;

    @Override
    public void addChatMember(Member member) {
        var chatMemberEntity = jpaPersistenceMemberMapper.toEntity(member);
        jpaMemberRepository.save(chatMemberEntity);
    }

    @Override
    public void removeChatMemberByName(String name) {
        jpaMemberRepository.delete(name);
    }

    @Override
    public Member getChatMemberByName(String name) {
        var chatMemberEntity = jpaMemberRepository.getByName(name);
        return jpaPersistenceMemberMapper.toDomain(chatMemberEntity);
    }
}
