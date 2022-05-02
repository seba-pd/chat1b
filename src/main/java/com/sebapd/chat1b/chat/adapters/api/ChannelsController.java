package com.sebapd.chat1b.chat.adapters.api;

import com.sebapd.chat1b.chat.adapters.api.dtos.ChannelDto;
import com.sebapd.chat1b.chat.adapters.api.mappers.RestChannelMapper;
import com.sebapd.chat1b.chat.ports.ChannelsService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("channels")
public class ChannelsController {

    @Inject
    private ChannelsService channelsService;
    @Inject
    private RestChannelMapper restChannelMapper;

    @POST
    @Path("add_channel")
    public void addChannel(ChannelDto channelDto){
        channelsService.addChannel(channelDto.getChannelName());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChannelList(){
        var channels =  channelsService.getChannelList();
        List<ChannelDto> channelDtoList = channels.stream().map(restChannelMapper::toDto).toList();
        List<String> channelNames = channelDtoList.stream().map(ChannelDto::getChannelName).toList();
        return Response.status(Response.Status.ACCEPTED).entity(channelNames ).build();
    }
}
