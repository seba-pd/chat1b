package com.sebapd.chat1b.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public
class ClientApi {

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
            ex.printStackTrace();
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
            e.printStackTrace();
        }
        return jsonResponse;
    }
}
