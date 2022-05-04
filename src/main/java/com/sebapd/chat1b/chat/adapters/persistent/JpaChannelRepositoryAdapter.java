package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceChannelMapper;
import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceMemberMapper;
import com.sebapd.chat1b.chat.adapters.persistent.repositories.JpaChannelRepository;
import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.ports.ChannelRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor(onConstructor_ =@Inject )
public class JpaChannelRepositoryAdapter implements ChannelRepository {

    private final JpaChannelRepository jpaChannelRepository;
    private final JpaPersistenceChannelMapper jpaPersistenceChannelMapper;
    private final JpaPersistenceMemberMapper jpaPersistenceMemberMapper;

    @Override
    public void addMemberToChannel(Member member, Channel channel) {
        var memberEntity = jpaPersistenceMemberMapper.toEntity(member);
        var channelEntity = jpaPersistenceChannelMapper.toEntity(channel);
        jpaChannelRepository.addChannelMember(memberEntity, channelEntity);
    }

    @Override
    public void removeChannelMember(Member member, Channel channel) {
        var memberEntity = jpaPersistenceMemberMapper.toEntity(member);
        var channelEntity = jpaPersistenceChannelMapper.toEntity(channel);
        jpaChannelRepository.removeChannelMember(memberEntity, channelEntity);
    }

    @Override
    public List<Member> getChannelMembers(Channel channel) {
        var channelEntity = jpaPersistenceChannelMapper.toEntity(channel);
        var memberEntities = jpaChannelRepository.getChannelMembers(channelEntity);
        return memberEntities.stream().map(jpaPersistenceMemberMapper::toDomain).toList();
    }
}
