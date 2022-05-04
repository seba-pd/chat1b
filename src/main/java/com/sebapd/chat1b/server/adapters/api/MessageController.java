package com.sebapd.chat1b.server.adapters.api;

import com.sebapd.chat1b.server.adapters.api.dtos.MessageDto;
import com.sebapd.chat1b.server.adapters.api.mappers.RestMessageMapper;
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
    @Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Response sendMessage(MessageDto messageDto){
        var message = restMessageMapper.toDomain(messageDto);
        messageService.send(message,messageDto.getChannelName());
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
