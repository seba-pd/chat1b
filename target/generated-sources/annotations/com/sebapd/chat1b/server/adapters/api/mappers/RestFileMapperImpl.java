package com.sebapd.chat1b.server.adapters.api.mappers;

import com.sebapd.chat1b.server.adapters.api.dtos.FileDto;
import com.sebapd.chat1b.server.domain.File;
import com.sebapd.chat1b.server.domain.File.FileBuilder;
import java.time.Instant;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-10T17:23:15+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class RestFileMapperImpl implements RestFileMapper {

    @Override
    public File toDomain(FileDto fileDto) {
        if ( fileDto == null ) {
            return null;
        }

        FileBuilder file = File.builder();

        file.content( RestFileMapper.stringToBytes( fileDto.getContent() ) );
        file.memberName( fileDto.getMemberName() );
        file.fileName( fileDto.getFileName() );
        file.channelName( fileDto.getChannelName() );

        file.createTime( java.sql.Timestamp.from(Instant.now()) );
        file.fileId( java.util.UUID.randomUUID() );

        return file.build();
    }

    @Override
    public FileDto toDto(File file) {
        if ( file == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        fileDto.setContent( RestFileMapper.bytesToString( file.getContent() ) );
        fileDto.setFileId( file.getFileId() );
        fileDto.setMemberName( file.getMemberName() );
        fileDto.setFileName( file.getFileName() );
        fileDto.setChannelName( file.getChannelName() );
        fileDto.setCreateTime( file.getCreateTime() );

        return fileDto;
    }
}
