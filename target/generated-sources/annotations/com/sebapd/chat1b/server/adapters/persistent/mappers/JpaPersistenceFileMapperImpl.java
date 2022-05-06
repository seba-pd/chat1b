package com.sebapd.chat1b.server.adapters.persistent.mappers;

import com.sebapd.chat1b.server.adapters.persistent.entities.FileEntity;
import com.sebapd.chat1b.server.domain.File;
import com.sebapd.chat1b.server.domain.File.FileBuilder;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T00:20:24+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class JpaPersistenceFileMapperImpl implements JpaPersistenceFileMapper {

    @Override
    public File toDomain(FileEntity fileEntity) {
        if ( fileEntity == null ) {
            return null;
        }

        FileBuilder file = File.builder();

        file.fileId( fileEntity.getFileId() );
        file.memberName( fileEntity.getMemberName() );
        file.fileName( fileEntity.getFileName() );
        file.contentLocation( fileEntity.getContentLocation() );
        file.createTime( fileEntity.getCreateTime() );

        return file.build();
    }

    @Override
    public FileEntity toEntity(File file) {
        if ( file == null ) {
            return null;
        }

        FileEntity fileEntity = new FileEntity();

        fileEntity.setFileId( file.getFileId() );
        fileEntity.setMemberName( file.getMemberName() );
        fileEntity.setFileName( file.getFileName() );
        fileEntity.setContentLocation( file.getContentLocation() );
        fileEntity.setCreateTime( file.getCreateTime() );

        return fileEntity;
    }
}
