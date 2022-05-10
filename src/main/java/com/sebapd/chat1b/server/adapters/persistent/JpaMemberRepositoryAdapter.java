package com.sebapd.chat1b.server.adapters.persistent;

import com.sebapd.chat1b.server.adapters.persistent.mappers.JpaPersistenceMemberMapper;
import com.sebapd.chat1b.server.adapters.persistent.repositories.JpaMemberRepository;
import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.ports.MemberRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
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
    public void removeChatMemberByName(String memberName) {
        jpaMemberRepository.delete(memberName);
    }

    @Override
    public Optional<Member> getChatMemberByName(String name) {
        var optionalChatMemberEntity = jpaMemberRepository.getByName(name);
        return optionalChatMemberEntity.map(jpaPersistenceMemberMapper::toDomain);
    }
}
