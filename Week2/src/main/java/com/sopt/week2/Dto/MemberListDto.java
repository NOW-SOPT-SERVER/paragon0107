package com.sopt.week2.Dto;

import com.sopt.week2.Domain.Member;
import com.sopt.week2.Domain.enums.Part;

import java.util.List;

public record MemberListDto(
        Long size,
        List<Member> memberList
) {

    public static MemberListDto of(List<Member> memberList) {
        return new MemberListDto(
                (long) memberList.size(),
                memberList
        );
    }
}