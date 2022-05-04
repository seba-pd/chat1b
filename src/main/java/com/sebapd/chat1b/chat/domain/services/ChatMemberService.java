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

    private final MemberRepository memberRepository;

    @Override
    public void addChatMember(String name) {
        memberRepository.addChatMember(
                Member.builder()
                        .memberId(UUID.randomUUID())
                        .createDate(Timestamp.from(Instant.now()))
                        .memberName(name)
                        .build());
    }

    @Override
    public void removeChatMemberByName(String memberName) {
            memberRepository.removeChatMemberByName(memberName);
    }
}
