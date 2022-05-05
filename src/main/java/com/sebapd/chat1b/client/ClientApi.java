package com.sebapd.chat1b.client;

import lombok.extern.java.Log;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Base64;

@Log
public class ClientApi {

    public void sendMessage(String channelName, String messageContent, String memberName, String url) {
        HttpClient httpClient = HttpClientBuilder.create().build();

        String jsonInputString = "{\"memberName\" : \"" + memberName + "\",\"channelName\" : \""
                + channelName + "\"," + "\"content\" : \"" + messageContent + "\"}";
        try {
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity(jsonInputString);
            params.setContentType("application/json");
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Accept", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
        } catch (Exception ex) {
            log.info("Bad request");
        }
    }

    public String getHistory(String channelName, String memberName, String url) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String requestUrl = url + "/" + channelName + "/" + memberName;
        HttpGet request = new HttpGet(requestUrl);
        String jsonResponse = null;
        try {
            var response = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(response.getEntity());

        } catch (IOException e) {
            log.info("Bad request");
        }
        return jsonResponse;
    }


    public String sendFile(String fileName, String channelName, byte[] content, String memberName, String url) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String jsonResponse = null;
        try {
            HttpPost request = new HttpPost(url);
            var requestContent = Base64.getEncoder().encodeToString(content);
            String jsonInputString = "{\"memberName\" : \"" + memberName + "\",\"channelName\" : \""
                    + channelName + "\"," + "\"content\" : \"" + requestContent + "\",\"fileName\" : \""
                    + fileName + "\"}";
            StringEntity params = new StringEntity(jsonInputString);
            params.setContentType("application/json");
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Accept", "application/json");
            request.setEntity(params);
            var response = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            log.info("Bad request");
        }
        return jsonResponse;
    }

    public String receiveFile(String fileName, String memberName, String channelName, String url) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String jsonResponse = null;
        String requestUrl = url + "/" + channelName + "/" + memberName + "/" + fileName;
        HttpGet request = new HttpGet(requestUrl);
        try {
            var response = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            log.info("Bad request");
        }
        return jsonResponse;
    }


}
