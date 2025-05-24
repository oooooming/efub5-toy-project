package com.example.twitter.member.controller;

import com.example.twitter.member.dto.request.CreateMemberRequestDTO;
import com.example.twitter.member.dto.response.MemberResponseDTO;
import com.example.twitter.member.entity.Member;
import com.example.twitter.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 생성: POST /members
    @PostMapping
    public ResponseEntity<MemberResponseDTO> createMember(@RequestBody @Valid CreateMemberRequestDTO request) {
        MemberResponseDTO newMember = memberService.createMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMember);
    }

    // 회원 조회
}
