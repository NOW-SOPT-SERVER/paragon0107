package com.sopt.week2.Controller;

import com.sopt.week2.Service.Dto.MemberCreateDto;
import com.sopt.week2.Service.Dto.MemberFindDto;
import com.sopt.week2.Service.Dto.MemberListDto;
import com.sopt.week2.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;


    @PostMapping
    public ResponseEntity<Void> createMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }


    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMemberById(
            @PathVariable Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<MemberListDto> findAllMembers() {
        return ResponseEntity.ok(memberService.findMembersAll());
    }
}
