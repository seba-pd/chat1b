package com.sebapd.chat1b.chat.adapters.persistent.mappers;

import com.sebapd.chat1b.chat.adapters.persistent.entities.FileEntity;
import com.sebapd.chat1b.chat.domain.File;
import com.sebapd.chat1b.chat.domain.File.FileBuilder;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T14:01:03+0200",
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
        file.author( fileEntity.getAuthor() );
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
        fileEntity.setAuthor( file.getAuthor() );
        fileEntity.setFileName( file.getFileName() );
        fileEntity.setContentLocation( file.getContentLocation() );
        fileEntity.setCreateTime( file.getCreateTime() );

        return fileEntity;
    }
}
