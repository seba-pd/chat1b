package com.sebapd.chat1b;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class Test {

    @GET
    public String test(){
        return "dddd";
    }
}
