package com.example.twitter.member.service;

import com.example.twitter.member.dto.request.CreateMemberRequestDTO;
import com.example.twitter.member.dto.response.MemberResponseDTO;
import com.example.twitter.member.entity.Member;
import com.example.twitter.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 생성
    public MemberResponseDTO createMember(CreateMemberRequestDTO request) {
        if(memberRepository.existsByAccount(request.getAccount())) {
            throw new IllegalArgumentException("account_id already exists");
        }
        Member newMember = request.toEntity();
        Member response = memberRepository.save(newMember);
        return MemberResponseDTO.of(response);
    }

    // 회원 조회
}
