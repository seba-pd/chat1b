package com.sebapd.chat1b.chat.domain.services;

import com.sebapd.chat1b.chat.domain.Member;
import com.sebapd.chat1b.chat.ports.MemberRepository;
import com.sebapd.chat1b.chat.ports.MemberService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject )
public class ChatMemberService implements MemberService {

    private final MemberRepository chatMemberRepository;

    @Override
    public void addChatMember(String name) {
        chatMemberRepository.addChatMember(
                Member.builder()
                        .memberId(UUID.randomUUID())
                        .createDate(Timestamp.from(Instant.now()))
                        .name(name)
                        .build());
    }

    @Override
    public void removeChatMemberByName(String name) {
        chatMemberRepository.removeChatMemberByName(name);
    }
}
