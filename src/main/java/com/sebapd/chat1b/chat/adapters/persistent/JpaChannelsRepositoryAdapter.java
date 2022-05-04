package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceChannelMapper;
import com.sebapd.chat1b.chat.adapters.persistent.repositories.JpaChannelsRepository;
import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.ports.ChannelsRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public void deleteChannel(String channelName){
        jpaChannelsRepository.deleteChannel(channelName);
    }

    @Override
    public List<Channel> getChannelList() {
        var channelEntities = jpaChannelsRepository.getChannels();
        return channelEntities.stream().map(jpaPersistenceChannelMapper::toDomain).toList();
    }

    @Override
    public Optional<Channel> getChannelByName(String channelName) {
        var optionalChannelEntity = jpaChannelsRepository.getByName(channelName);
        return optionalChannelEntity.map(jpaPersistenceChannelMapper::toDomain);
    }
}
