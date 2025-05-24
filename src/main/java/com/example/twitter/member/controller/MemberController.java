package com.example.twitter.member.controller;

import com.example.twitter.member.dto.request.CreateMemberRequestDTO;
import com.example.twitter.member.dto.response.MemberResponseDTO;
import com.example.twitter.member.entity.Member;
import com.example.twitter.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 생성: POST /members
    @PostMapping
    public ResponseEntity<MemberResponseDTO> createMember(@RequestBody @Valid CreateMemberRequestDTO request) {
        MemberResponseDTO Member = memberService.createMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Member);
    }

    // 회원 조회
    @GetMapping("/{member_id}")
    public ResponseEntity<MemberResponseDTO> getMember(@PathVariable("member_id") Long member_id) {
        MemberResponseDTO Member = memberService.getMember(member_id);
        return ResponseEntity.status(HttpStatus.OK).body(Member);
    }
}
