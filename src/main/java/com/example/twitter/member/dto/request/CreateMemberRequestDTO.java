package com.example.twitter.member.dto.request;

import com.example.twitter.member.entity.Member;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateMemberRequestDTO {
    @NotNull String account;
    @NotNull String password;
    @NotNull String username;
    @NotNull String bio;

    public Member toEntity() {
        return Member.builder()
                .account(account)
                .password(password)
                .username(username)
                .bio(bio)
                .build();
    }
}
