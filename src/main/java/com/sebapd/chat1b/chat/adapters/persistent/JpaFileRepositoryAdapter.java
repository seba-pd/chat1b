package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceChannelMapper;
import com.sebapd.chat1b.chat.adapters.persistent.mappers.JpaPersistenceFileMapper;
import com.sebapd.chat1b.chat.adapters.persistent.repositories.JpaFileRepository;
import com.sebapd.chat1b.chat.domain.Channel;
import com.sebapd.chat1b.chat.domain.File;
import com.sebapd.chat1b.chat.ports.FileRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaFileRepositoryAdapter implements FileRepository {

    private final JpaPersistenceChannelMapper jpaPersistenceChannelMapper;
    private final JpaPersistenceFileMapper jpaPersistenceFileMapper;
    private final JpaFileRepository jpaFileRepository;


    @Override
    public Optional<File> getFileByName(String fileName) {
        var optionalFileEntity = jpaFileRepository.getFileByFileName(fileName);
        return optionalFileEntity.map(jpaPersistenceFileMapper::toDomain);
    }

    @Override
    public void sendFile(File file, Channel channel) {
        var fileEntity = jpaPersistenceFileMapper.toEntity(file);
        var channelEntity = jpaPersistenceChannelMapper.toEntity(channel);
        jpaFileRepository.sendFile(fileEntity, file.getContent(), channelEntity);
    }
    @Override
    public byte[] receiveContent(String fileLocation){
        return jpaFileRepository.receiveFileContent(fileLocation);
    }
}
