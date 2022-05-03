package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceChannelMapper;
import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceMemberMapper;
import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceMessageMapper;
import com.sebapd.chat1b.chat.adapters.persistent.repositories.JpaMessageRepository;
import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.Message;
import com.sebapd.chat1b.chat.ports.MessageRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaMessageRepositoryAdapter implements MessageRepository {

    private final JpaMessageRepository jpaMessageRepository;
    private final JpaPersistenceMessageMapper jpaPersistenceMessageMapper;
    private final JpaPersistenceChannelMapper jpaPersistenceChannelMapper;

    @Override
    public void sendMessage(Message message, Channel channel) {
        var messageEntity = jpaPersistenceMessageMapper.toEntity(message);
        var channelEntity = jpaPersistenceChannelMapper.toEntity(channel);
        var membersList= channelEntity.getChannelMembers().stream().map(MemberEntity::getMemberName).toList();
        messageEntity.getAccessMembersList().addAll(membersList);
        jpaMessageRepository.sendMessage(messageEntity,channelEntity);
    }
}
