package com.sebapd.chat1b.client;

import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
        ChannelService channelService = new ChannelService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String memberName = scanner.nextLine();

        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "/s" -> channelService.sendMessage(scanner, memberName);
                case "/h" -> channelService.getHistory(scanner, memberName);
                case "/sf" -> channelService.sendFile(scanner, memberName);
                case "/rf" -> channelService.receiveFile(scanner, memberName);
            }

        }
    }


}
