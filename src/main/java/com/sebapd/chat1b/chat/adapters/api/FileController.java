package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.FileDto;
import com.sebapd.chat1b.chat.adapters.api.mappers.RestFileMapper;
import com.sebapd.chat1b.chat.domain.File;
import com.sebapd.chat1b.chat.ports.FileService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("file")
public class FileController {

    @Inject
    private FileService fileService;
    @Inject
    private RestFileMapper restFileMapper;

    @Path("send_file")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendFile(FileDto fileDto) {
        var file = restFileMapper.toDomain(fileDto);
        fileService.sendFile(file.getFileName(), file.getAuthor(), file.getContent(), fileDto.getChannelName());
    }
}
