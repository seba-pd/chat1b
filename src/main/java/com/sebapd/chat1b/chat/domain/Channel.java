package com.sebapd.chat1b.chat.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RequiredArgsConstructor
public class Channel {

    private Long id;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<ChatMember> chatMembers = new LinkedList<>();
    @NonNull
    @Getter
    private String name;

}
