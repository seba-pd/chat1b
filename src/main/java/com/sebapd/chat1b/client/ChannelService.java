package com.sebapd.chat1b.client;

import java.util.Scanner;


public class ChannelService {

    private final ClientApi clientApi = new ClientApi();
    private final ClientUi clientUi = new ClientUi();
    private static final String HISTORY_URL = "http://localhost:8080/chat1b-1.0-SNAPSHOT/chat/channel/history/";
    private static final String SEND_MESSAGE_URL = "http://localhost:8080/chat1b-1.0-SNAPSHOT/chat/message/send";

    public void sendMessage(Scanner scanner, String memberName) {
        System.out.println("Enter channel name: ");
        String channelName = scanner.nextLine();
        System.out.println("Enter text: ");
        String messageContent = scanner.nextLine();
        clientApi.sendMessage(channelName, messageContent, memberName, SEND_MESSAGE_URL);
    }

    public void getHistory(Scanner scanner, String memberName) {
        System.out.println("Enter channel name: ");
        String channelName = scanner.nextLine();
        var response = clientApi.getHistory(channelName, memberName, HISTORY_URL);
        clientUi.writeHistory(response);
    }

}

