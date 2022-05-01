package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.ChannelDto;
import com.sebapd.chat1b.chat.ports.ChannelsService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("channels")
public class ChannelsController {

    @Inject
    private ChannelsService channelsService;

    @POST
    @Path("add_channel")
    public void addChannel(ChannelDto channelDto){
        channelsService.addChannel(channelDto.getChannelName());
    }

    @GET
    public Response getChannelList(){
        var channels =  channelsService.getChannelList();
        return Response.status(Response.Status.ACCEPTED).entity(channels).build();
    }
}
