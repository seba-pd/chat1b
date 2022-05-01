package com.sebapd.chat1b.chat.ports;

import com.sebapd.chat1b.chat.domain.Message;

import java.util.List;

public interface HistoryService {

    List<Message> getChannelHistory(String channelName);
}
