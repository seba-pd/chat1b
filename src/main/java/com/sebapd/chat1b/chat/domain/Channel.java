package com.sebapd.chat1b.chat.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Builder
@Getter
public class Channel {

    private final UUID channelId;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<Member> channelMembers;
    private final String channelName;
    private final List<Message> messageList;

}
