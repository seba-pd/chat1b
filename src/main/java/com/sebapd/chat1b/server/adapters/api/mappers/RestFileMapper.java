package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.FileDto;
import com.sebapd.chat1b.server.domain.File;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;

@Mapper(componentModel = "cdi")
public interface RestFileMapper {

    @Mapping(source = "content", target = "content", qualifiedByName = "contentToBytes")
    File toDomain(FileDto fileDto);
    @Mapping(source = "content", target = "content", qualifiedByName = "contentToString")
    @Mapping(target = "createTime", expression = "java(java.sql.Timestamp.from(Instant.now()))")
    @Mapping(target = "fileId", expression = "java(java.util.UUID.randomUUID())")
    FileDto toDto(File file);

    @Named("contentToBytes")
    static byte[] stringToBytes(String content){
        return Base64.getDecoder().decode(content);
    }
    @Named("contentToString")
    static String bytesToString(byte[] content){
        return Base64.getEncoder().encodeToString(content);
    }
}
