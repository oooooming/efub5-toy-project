package com.example.twitter.twit.dto.response;

import com.example.twitter.member.entity.Member;
import com.example.twitter.twit.entity.Twit;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TwitResponseDTO {
    private long twit_id;
    private long member_id;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public static TwitResponseDTO of(Twit twit) {
        return TwitResponseDTO.builder()
                .twit_id(twit.getTwit_id())
                .member_id(twit.getMember().getMember_id())
                .content(twit.getContent())
                .created_at(twit.getCreated_at())
                .updated_at(twit.getUpdated_at())
                .build();
    }
}
