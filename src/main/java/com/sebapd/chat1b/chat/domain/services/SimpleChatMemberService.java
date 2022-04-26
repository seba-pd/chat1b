package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.ChatMember;
import com.sebapd.chat1b.chat.ports.ChatMemberRepository;
import com.sebapd.chat1b.chat.ports.ChatMemberService;

import javax.inject.Inject;
import java.util.UUID;

public class SimpleChatMemberService implements ChatMemberService {

    private final ChatMemberRepository chatMemberRepository;

    @Inject
    public SimpleChatMemberService(ChatMemberRepository chatMemberRepository) {
        this.chatMemberRepository = chatMemberRepository;
    }

    @Override
    public void addChatMember(String name) {
        chatMemberRepository.addChatMember(
                ChatMember.builder()
                        .name(name)
                        .build());
    }

    @Override
    public void removeChatMemberByName(String name) {
        chatMemberRepository.removeChatMemberByName(name);
    }
}
