package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.chat.adapters.persistent.entities.MemberEntity;
import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceChannelMapper;
import com.sebapd.chat1b.chat.adapters.persistent.repositories.JpaChannelRepository;
import com.sebapd.chat1b.chat.adapters.persistent.repositories.JpaChannelsRepository;
import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.ports.ChannelsRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaChannelsRepositoryAdapter implements ChannelsRepository {

    private final JpaChannelsRepository jpaChannelsRepository;
    private final JpaPersistenceChannelMapper jpaPersistenceChannelMapper;

    @Override
    public void addChannel(Channel channel) {
        var channelEntity = jpaPersistenceChannelMapper.toEntity(channel);
        jpaChannelsRepository.addChannel(channelEntity);
    }
    @Override
    public void deleteChannel(Channel channel){
        var channelEntity = jpaPersistenceChannelMapper.toEntity(channel);
        jpaChannelsRepository.deleteChannel(channelEntity);
    }

    @Override
    public List<Channel> getChannelList() {
        var channelEntities = jpaChannelsRepository.getChannels();
        return channelEntities.stream().map(jpaPersistenceChannelMapper::toDomain).toList();
    }

    @Override
    public Optional<Channel> getChannelByName(String channelName) {
        var channelEntity = jpaChannelsRepository.getByName(channelName);
        return Optional.ofNullable(jpaPersistenceChannelMapper.toDomain(channelEntity));
    }
}
