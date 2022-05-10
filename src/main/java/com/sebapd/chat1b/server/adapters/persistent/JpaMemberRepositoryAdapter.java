package com.sebapd.chat1b.server.adapters.persistent;

import com.sebapd.chat1b.server.adapters.persistent.mappers.JpaPersistenceChannelMapper;
import com.sebapd.chat1b.server.adapters.persistent.mappers.JpaPersistenceMemberMapper;
import com.sebapd.chat1b.server.adapters.persistent.repositories.JpaMemberRepository;
import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.ports.MemberRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject )
public class JpaMemberRepositoryAdapter implements MemberRepository {

    private final JpaPersistenceMemberMapper jpaPersistenceMemberMapper;
    private final JpaMemberRepository jpaMemberRepository;
    private final JpaPersistenceChannelMapper jpaPersistenceChannelMapper;

    @Override
    public void addChatMember(Member member) {
        var MemberEntity = jpaPersistenceMemberMapper.toEntity(member);
        jpaMemberRepository.save(MemberEntity);
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

    public List<String> getMemberChannels(String memberName){
        return jpaMemberRepository.getMemberChannelsNames(memberName);
    }
}
