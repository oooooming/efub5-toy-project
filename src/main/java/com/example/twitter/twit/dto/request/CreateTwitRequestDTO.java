package com.example.twitter.twit.dto.request;

import com.example.twitter.member.entity.Member;
import com.example.twitter.twit.entity.Twit;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateTwitRequestDTO {
    @NotNull long member_id;
    @NotNull String content;

    public Twit toEntity(Member member) {
        return Twit.builder()
                .member(member)
                .content(content)
                .build();
    }
}
