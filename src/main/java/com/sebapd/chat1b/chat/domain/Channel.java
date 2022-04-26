package com.sebapd.chat1b.chat.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Builder
public class Channel {

    private UUID id;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<ChatMember> chatMembers = new LinkedList<>();
    @Getter
    private String name;

}
