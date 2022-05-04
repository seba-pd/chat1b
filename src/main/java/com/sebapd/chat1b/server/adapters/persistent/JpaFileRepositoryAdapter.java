package com.sebapd.chat1b.server.adapters.persistent;

import com.sebapd.chat1b.server.adapters.persistent.mappers.JpaPersistenceChannelMapper;
import com.sebapd.chat1b.server.adapters.persistent.mappers.JpaPersistenceFileMapper;
import com.sebapd.chat1b.server.adapters.persistent.repositories.JpaFileRepository;
import com.sebapd.chat1b.server.domain.Channel;
import com.sebapd.chat1b.server.domain.File;
import com.sebapd.chat1b.server.ports.FileRepository;
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
