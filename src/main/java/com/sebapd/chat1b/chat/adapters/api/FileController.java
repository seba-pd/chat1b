package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.FileDto;
import com.sebapd.chat1b.chat.adapters.api.mappers.RestFileMapper;
import com.sebapd.chat1b.chat.ports.FileService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("file")
public class FileController {

    @Inject
    private FileService fileService;
    @Inject
    private RestFileMapper restFileMapper;

    @Path("send_file")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendFile(FileDto fileDto) {
        var file = restFileMapper.toDomain(fileDto);
        fileService.sendFile(file.getFileName(), file.getMemberName(), file.getContent(), fileDto.getChannelName());
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("receive_file")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveFile(FileDto fileDto){
        var file = fileService.getFileByName(fileDto.getFileName(),fileDto.getMemberName(), fileDto.getChannelName());
        var responseFile = restFileMapper.toDto(file);
        return Response.status(Response.Status.OK).entity(responseFile).build();
    }
}
