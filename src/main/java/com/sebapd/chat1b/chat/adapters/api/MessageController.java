package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.MessageDto;
import com.sebapd.chat1b.chat.adapters.api.mappers.RestMessageMapper;
import com.sebapd.chat1b.chat.ports.MessageService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("message")
public class MessageController {

    @Inject
    private  MessageService messageService;
    @Inject
    private RestMessageMapper restMessageMapper;

    @Path("send")
    @POST
    public Response sendMessage(MessageDto messageDto){
        var message = restMessageMapper.toDomain(messageDto);
        messageService.send(message,messageDto.getToChannel());
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
