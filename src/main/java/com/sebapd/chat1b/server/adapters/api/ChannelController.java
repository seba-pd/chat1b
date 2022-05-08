package com.sebapd.chat1b.server.adapters.api;

import com.sebapd.chat1b.server.adapters.api.dtos.MemberChannelDto;
import com.sebapd.chat1b.server.adapters.api.mappers.RestMessageMapper;
import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.domain.exceptions.ChannelNotFoundException;
import com.sebapd.chat1b.server.domain.exceptions.MemberAlreadyExistInChannelException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotExistInChannelException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotFoundException;
import com.sebapd.chat1b.server.ports.ChannelService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("channel")
public class ChannelController {

    @Inject
    private ChannelService channelService;
    @Inject
    private RestMessageMapper restMessageMapper;

    @Path("add_member_to_channel")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMemberToChannel(MemberChannelDto memberChannelDto) {
        try {
            channelService.addMemberToChannel(memberChannelDto.getMemberName(),
                    memberChannelDto.getChannelName());
        } catch (MemberAlreadyExistInChannelException | ChannelNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("history/{channelName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHistory(@PathParam("channelName") String channelName,
                               @QueryParam("memberName") String memberName) {
        List<Message> messageList;
        try {
            messageList = channelService.getHistory(channelName, memberName);
        } catch (MemberNotExistInChannelException | ChannelNotFoundException | MemberNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        var messageDtoList = messageList.stream()
                .map(message -> restMessageMapper.toDto(message))
                .toList();
        return Response.status(Response.Status.OK).entity(messageDtoList).build();
    }

    @Path("remove_member_from_channel")
    @DELETE
    public Response removeMemberFromChannel(@QueryParam("memberName") String memberName,
                                            @QueryParam("channelName") String channelName) {
        try {
            channelService.removeChannelMember(memberName, channelName);
        } catch (ChannelNotFoundException | MemberNotFoundException | MemberNotExistInChannelException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).build();
    }
}
