package com.sebapd.chat1b.server.adapters.api;

import com.sebapd.chat1b.server.adapters.api.dtos.FileDto;
import com.sebapd.chat1b.server.adapters.api.mappers.RestFileMapper;
import com.sebapd.chat1b.server.domain.File;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.FileNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotExistInChannel;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotFoundException;
import com.sebapd.chat1b.server.ports.FileService;

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
        try {
            fileService.sendFile(file.getFileName(), file.getMemberName(), file.getContent(), fileDto.getChannelName());
        } catch (MemberNotFoundException | MemberNotExistInChannel | ChannelNotFoundException e) {
            return Response.status(Response.Status.OK).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("{channelName}/{memberName}/{fileName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveFile(@PathParam("channelName") String channelName,
                                @PathParam("memberName") String memberName,
                                @PathParam("fileName") String fileName) {
        File file ;
        try {
            file = fileService.getFileByName(fileName, memberName, channelName);
        } catch (FileNotFoundException | MemberNotFoundException | ChannelNotFoundException| MemberNotExistInChannel e) {
            return Response.status(Response.Status.OK).entity(e.getMessage()).build();
        }
        var responseFile = restFileMapper.toDto(file);
        return Response.status(Response.Status.OK).entity(responseFile).build();
    }
}
