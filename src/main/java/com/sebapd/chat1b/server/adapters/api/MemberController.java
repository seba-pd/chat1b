package com.sebapd.chat1b.server.adapters.api;

import com.sebapd.chat1b.server.adapters.api.dtos.MemberDto;
import com.sebapd.chat1b.server.adapters.api.mappers.RestMemberMapper;
import com.sebapd.chat1b.server.domain.exceptions.MemberAlreadyExistException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotFoundException;
import com.sebapd.chat1b.server.ports.MemberService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "member")
public class MemberController {

    @Inject
    private MemberService memberService;
    @Inject
    private RestMemberMapper restMemberMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addChatMember(MemberDto memberDto){
        try {
            memberService.addChatMember(restMemberMapper.toDomain(memberDto));
        } catch (MemberAlreadyExistException e) {
            return Response.status(Response.Status.OK).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("channels/{name}")
    public Response getMemberChannels(@PathParam("name") String memberName){
        String channels ;
        try {
           var channelsListNames = memberService.getMemberChannels(memberName);
           channels = String.join(",", channelsListNames);
        } catch (MemberNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(channels).build();
    }

    @DELETE
    @Path("{name}")
    public Response deleteByName(@PathParam("name") String memberName){
        memberService.removeChatMemberByName(memberName);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("{name}")
    public Response checkIfMemberExist(@PathParam("name") String memberName){
        try {
            memberService.checkIfMemberExist(memberName);
        } catch (MemberNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).build();
    }
}
