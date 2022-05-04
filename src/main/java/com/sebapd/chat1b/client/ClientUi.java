package com.sebapd.chat1b.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.Arrays;

public class ClientUi {

    @SneakyThrows
    public void writeHistory(String response){
        ObjectMapper mapper = new ObjectMapper();
        var messageList = Arrays.asList(mapper.readValue(response, Message[].class));
        messageList.forEach(message -> System.out.println(message.getCreateTime() + " : " +
                message.getMemberName() + " : " + message.getContent()));
    }
}
