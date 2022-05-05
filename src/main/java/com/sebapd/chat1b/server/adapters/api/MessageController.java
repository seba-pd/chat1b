package com.sebapd.chat1b.server.adapters.api;

import com.sebapd.chat1b.server.adapters.api.dtos.MessageDto;
import com.sebapd.chat1b.server.adapters.api.mappers.RestMessageMapper;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotExistInChannel;
import com.sebapd.chat1b.server.ports.MessageService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("message")
public class MessageController {

    @Inject
    private  MessageService messageService;
    @Inject
    private RestMessageMapper restMessageMapper;

    @Path("send")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendMessage(MessageDto messageDto){
        var message = restMessageMapper.toDomain(messageDto);
        try {
            messageService.send(message,messageDto.getChannelName());
        } catch (ChannelNotFoundException | MemberNotExistInChannel e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
