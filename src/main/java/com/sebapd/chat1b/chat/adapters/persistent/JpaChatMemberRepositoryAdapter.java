package com.sebapd.chat1b.chat.adapters.persistent;

import com.sebapd.chat1b.chat.domain.ChatMember;
import com.sebapd.chat1b.chat.ports.ChatMemberRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
public class JpaChatMemberRepositoryAdapter implements ChatMemberRepository {

    private final JpaPersistenceChatMemberMapper jpaPersistenceChatMemberMapper;
    private final JpaChatMemberRepository jpaChatMemberRepository;

    @Inject
    public JpaChatMemberRepositoryAdapter(JpaPersistenceChatMemberMapper jpaPersistenceChatMemberMapper, JpaChatMemberRepository jpaChatMemberRepository) {
        this.jpaPersistenceChatMemberMapper = jpaPersistenceChatMemberMapper;
        this.jpaChatMemberRepository = jpaChatMemberRepository;
    }

    @Override
    public void addChatMember(ChatMember chatMember) {
        var chatMemberEntity = jpaPersistenceChatMemberMapper.toEntity(chatMember);
        jpaChatMemberRepository.save(chatMemberEntity);
    }

    @Override
    public void removeChatMemberByName(String name) {

    }

    @Override
    public ChatMember getChatMemberByName(String name) {
        return null;
    }
}
