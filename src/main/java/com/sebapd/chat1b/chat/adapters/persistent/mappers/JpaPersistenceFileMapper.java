package com.sebapd.chat1b.chat.adapters.persistent.mappers;

import com.sebapd.chat1b.chat.adapters.persistent.entities.FileEntity;
import com.sebapd.chat1b.chat.domain.File;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "cdi", imports = UUID.class)
public interface JpaPersistenceFileMapper {

    File toDomain(FileEntity fileEntity);
    FileEntity toEntity(File file);


}
