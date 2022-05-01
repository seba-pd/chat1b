package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.AddMemberToChannelDto;
import com.sebapd.chat1b.chat.ports.ChannelService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("channel")
public class ChannelController {

    @Inject
    private ChannelService channelService;

    @Path("add_member_to_channel")
    @POST
    public void addMemberToChannel(AddMemberToChannelDto addMemberToChannelDto){

        channelService.addMemberToChannel(addMemberToChannelDto.getMemberName(),
                addMemberToChannelDto.getChannelName());
    }
}
