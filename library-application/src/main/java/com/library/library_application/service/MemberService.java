package com.library.library_application.service;

import com.library.library_application.model.Member;
import com.library.library_application.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }


    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Optional<Member> getMemberById(int id) {
        return memberRepository.findById(id);
    }


    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }
}
