package me.jmlee.springdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.jmlee.springdeveloper.entity.Member;
import me.jmlee.springdeveloper.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
}