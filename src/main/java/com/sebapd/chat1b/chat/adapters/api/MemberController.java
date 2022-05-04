package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.MemberDto;
import com.sebapd.chat1b.chat.ports.MemberService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "member")
public class MemberController {

    @Inject
    private MemberService memberService;

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addChatMember(MemberDto memberDto){
        memberService.addChatMember(memberDto.getMemberName());
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{name}")
    public Response deleteByName(@PathParam("name") String memberName){
        memberService.removeChatMemberByName(memberName);
        return Response.status(Response.Status.OK).build();
    }

}
