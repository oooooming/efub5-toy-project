package com.example.twitter.twit.dto.response;

import com.example.twitter.member.entity.Member;
import com.example.twitter.twit.entity.Twit;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class TwitListResponseDTO {
    private List<TwitResponseDTO> twits;
    private long count;

    public static TwitListResponseDTO from(List<Twit> twits) {
        List<TwitResponseDTO> twitList = twits.stream()
                .map(TwitResponseDTO::of)
                .toList();

        return TwitListResponseDTO.builder()
                .count(twitList.size())
                .twits(twitList)
                .build();
    }
}
