package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.MemberDto;
import com.sebapd.chat1b.chat.ports.MemberService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(value = "member")
public class MemberController {

    @Inject
    private MemberService memberService;

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addChatMember(MemberDto memberDto){
        memberService.addChatMember(memberDto.getMemberName());
    }

    @DELETE
    @Path("/{name}")
    public void deleteByName(@PathParam("name") String name){
        memberService.removeChatMemberByName(name);
    }

}
