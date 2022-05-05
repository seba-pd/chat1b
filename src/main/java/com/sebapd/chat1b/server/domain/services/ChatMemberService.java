package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.exceptions.MemberAlreadyExistException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotFoundException;
import com.sebapd.chat1b.server.ports.MemberRepository;
import com.sebapd.chat1b.server.ports.MemberService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject )
public class ChatMemberService implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void addChatMember(String memberName) {
        if(memberRepository.getChatMemberByName(memberName).isPresent()) throw new MemberAlreadyExistException();
        memberRepository.addChatMember(
                Member.builder()
                        .memberId(UUID.randomUUID())
                        .createDate(Timestamp.from(Instant.now()))
                        .memberName(memberName)
                        .build());
    }

    @Override
    public void removeChatMemberByName(String memberName) {
            memberRepository.removeChatMemberByName(memberName);
    }

    @Override
    public void checkIfMemberExist(String memberName){
        memberRepository.getChatMemberByName(memberName)
                .orElseThrow(MemberNotFoundException::new);
    }
}
