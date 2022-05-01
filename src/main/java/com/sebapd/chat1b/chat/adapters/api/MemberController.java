package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.MemberDto;
import com.sebapd.chat1b.chat.ports.MemberService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path(value = "member")
public class MemberController {

    @Inject
    private MemberService memberService;

    @POST
    @Path("add")
    public void addChatMember(MemberDto memberDto){
        memberService.addChatMember(memberDto.getMemberName());
    }

    @DELETE
    @Path("/{name}")
    public void deleteByName(@PathParam("name") String name){
        memberService.removeChatMemberByName(name);
    }

}
