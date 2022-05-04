package com.sebapd.chat1b.server.adapters.api;

import com.sebapd.chat1b.server.adapters.api.dtos.MemberChannelDto;
import com.sebapd.chat1b.server.adapters.api.mappers.RestMessageMapper;
import com.sebapd.chat1b.server.ports.ChannelService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("channel")
public class ChannelController {

    @Inject
    private ChannelService channelService;
    @Inject
    private RestMessageMapper restMessageMapper;

    @Path("add_member_to_channel")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMemberToChannel(MemberChannelDto memberChannelDto){
        channelService.addMemberToChannel(memberChannelDto.getMemberName(),
                memberChannelDto.getChannelName());
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("history/{channelName}/{memberName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHistory(@PathParam("channelName") String channelName,
                               @PathParam("memberName") String memberName){
        var messageList = channelService.getHistory(channelName,memberName);
        var messageDtoList = messageList.stream()
                .map(message -> restMessageMapper.toDto(message))
                .toList();
        return Response.status(Response.Status.OK).entity(messageDtoList).build();
    }

    @Path("remove_member_from_channel")
    @DELETE
    public Response removeMemberFromChannel(MemberChannelDto memberChannelDto){
        channelService.removeChannelMember(memberChannelDto.getMemberName(),memberChannelDto.getChannelName());
        return Response.status(Response.Status.OK).build();
    }
}
