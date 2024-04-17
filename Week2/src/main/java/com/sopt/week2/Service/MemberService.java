package com.sopt.week2.Service;


import com.sopt.week2.Domain.Member;
import com.sopt.week2.Dto.MemberCreateDto;
import com.sopt.week2.Dto.MemberFindDto;
import com.sopt.week2.Dto.MemberListDto;
import com.sopt.week2.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;


    public String createMember(MemberCreateDto memberCreateDto) {
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
        memberRepository.save(member);
        return member.getId().toString();
    }

    public MemberFindDto findMemberById(Long memberId) {
        return MemberFindDto.of(memberRepository.findMemberById(memberId));

    }


    public void deleteMemberById(Long memberId) {
        memberRepository.delete(memberRepository.findMemberById(memberId));
    }

    public MemberListDto findMembersAll() {
        return MemberListDto.of(memberRepository.findAll());
    }
}
