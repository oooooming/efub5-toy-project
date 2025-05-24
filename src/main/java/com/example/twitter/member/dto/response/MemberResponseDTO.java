package com.example.twitter.member.dto.response;

import com.example.twitter.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MemberResponseDTO {
    private Long member_id;
    private String account;
    private String username;
    private String bio;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public static MemberResponseDTO of(Member member) {
        return MemberResponseDTO.builder()
                .member_id(member.getMember_id())
                .account(member.getAccount())
                .username(member.getUsername())
                .bio(member.getBio())
                .created_at(member.getCreated_at())
                .updated_at(member.getUpdated_at())
                .build();
    }
}
