package com.sebapd.chat1b.server.domain.services;

import com.sebapd.chat1b.server.domain.Member;
import com.sebapd.chat1b.server.domain.exceptions.MemberAlreadyExistException;
import com.sebapd.chat1b.server.domain.exceptions.MemberNotFoundException;
import com.sebapd.chat1b.server.ports.MemberRepository;
import com.sebapd.chat1b.server.ports.MemberService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject )
public class ChatMemberService implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void addChatMember(Member member) {
        if(memberRepository.getChatMemberByName(member.getMemberName())
                .isPresent()) throw new MemberAlreadyExistException();
        memberRepository.addChatMember(member);
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

    @Override
    public List<String> getMemberChannels(String memberName) {
        return memberRepository.getMemberChannels(memberName);
    }
}
