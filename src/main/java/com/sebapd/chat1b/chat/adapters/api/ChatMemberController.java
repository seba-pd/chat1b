package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.ports.ChatMemberService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path(value = "chatMember")
public class ChatMemberController {

    @Inject
    private ChatMemberService chatMemberService;

    @POST
    public void addChatMember(String name){
        chatMemberService.addChatMember(name);
    }

    @GET
    public String test1(){
        return "test1";
    }

}
