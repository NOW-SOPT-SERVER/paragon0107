package com.sopt.week2.Service;


import com.sopt.week2.Common.Dto.ErrorMessage;
import com.sopt.week2.Domain.Member;
import com.sopt.week2.Exception.NotFoundException;
import com.sopt.week2.Service.Dto.MemberCreateDto;
import com.sopt.week2.Service.Dto.MemberFindDto;
import com.sopt.week2.Service.Dto.MemberListDto;
import com.sopt.week2.Repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Member findById(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }

    public void deleteMemberById(Long memberId) {
        memberRepository.delete(memberRepository.findMemberById(memberId));
    }

    public MemberListDto findMembersAll() {
        return MemberListDto.of(memberRepository.findAll());
    }
}
