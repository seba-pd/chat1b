package com.sebapd.chat1b.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Scanner;

@Log
public class ChannelService {

    private final ClientApi clientApi = new ClientApi();
    private final ClientUi clientUi = new ClientUi();
    private static final String HISTORY_URL = "http://localhost:8080/chat1b-1.0-SNAPSHOT/chat/channel/history/";
    private static final String SEND_MESSAGE_URL = "http://localhost:8080/chat1b-1.0-SNAPSHOT/chat/message/send";
    private static final String SEND_FILE_URL = "http://localhost:8080/chat1b-1.0-SNAPSHOT/chat/file/send_file";
    private static final String RECEIVE_FILE_URL = "http://localhost:8080/chat1b-1.0-SNAPSHOT/chat/file/receive_file";

    public void sendMessage(Scanner scanner, String memberName) {
        log.info("Enter channel name: ");
        String channelName = scanner.nextLine();
        log.info("Enter text: ");
        String messageContent = scanner.nextLine();
        clientApi.sendMessage(channelName, messageContent, memberName, SEND_MESSAGE_URL);

    }

    public void getHistory(Scanner scanner, String memberName) {
        log.info("Enter channel name: ");
        String channelName = scanner.nextLine();
        var response = clientApi.getHistory(channelName, memberName, HISTORY_URL);
        clientUi.writeHistory(response);
    }


    public void sendFile(Scanner scanner, String memberName) {
        log.info("Enter channel name: ");
        var channelName = scanner.nextLine();
        log.info("Enter file name: ");
        var fileName = scanner.nextLine();
        log.info("Enter file path: ");
        var filePath = scanner.nextLine();
        try {
            var content = Files.readAllBytes(Path.of(filePath));
            var response = clientApi.sendFile(fileName,channelName,content,memberName,SEND_FILE_URL);
        } catch (IOException e) {
            log.info("File not found");
        }
    }


    public void receiveFile(Scanner scanner, String memberName) {
        log.info("Enter channel name: ");
        var channelName = scanner.nextLine();
        log.info("Enter file name: ");
        var fileName = scanner.nextLine();
        log.info("Enter path to save file: ");
        var filePath = scanner.nextLine();
        var response = clientApi.receiveFile(fileName,memberName,channelName,RECEIVE_FILE_URL);
        saveFile(response, filePath);
    }

    private void saveFile(String response, String filePath){
        ObjectMapper mapper = new ObjectMapper();
        try {
            var content = mapper.readValue(response, File.class);
            var contentBytes = Base64.getDecoder().decode(content.getContent());
            var file = new java.io.File(filePath);
            try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                fileOutputStream.write(contentBytes);
            } catch (FileNotFoundException e) {
                log.info("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            log.info("Mapper can't map content file");
        }
    }
}

