package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.ChatMessage;

import java.util.List;

public interface HistoryService {

    List<ChatMessage> getChannelHistory(String channelName);
}
