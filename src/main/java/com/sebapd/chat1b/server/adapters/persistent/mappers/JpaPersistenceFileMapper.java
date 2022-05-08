package com.sebapd.chat1b.server.adapters.persistent.mappers;

import com.sebapd.chat1b.server.adapters.persistent.entities.FileEntity;
import com.sebapd.chat1b.server.domain.File;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "cdi")
public interface JpaPersistenceFileMapper {

    File toDomain(FileEntity fileEntity);
    FileEntity toEntity(File file);


}
