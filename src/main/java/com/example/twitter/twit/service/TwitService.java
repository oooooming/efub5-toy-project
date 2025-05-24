package com.example.twitter.twit.service;

import com.example.twitter.member.entity.Member;
import com.example.twitter.member.repository.MemberRepository;
import com.example.twitter.twit.dto.request.CreateTwitRequestDTO;
import com.example.twitter.twit.dto.response.TwitListResponseDTO;
import com.example.twitter.twit.dto.response.TwitResponseDTO;
import com.example.twitter.twit.entity.Twit;
import com.example.twitter.twit.repository.TwitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TwitService {

    private final MemberRepository memberRepository;
    private final TwitRepository twitRepository;

    // 트윗 생성
    public TwitResponseDTO createTwit(CreateTwitRequestDTO request) {
        Member member = memberRepository.findById(request.getMember_id())
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Twit newTwit = request.toEntity(member);
        Twit savedTwit = twitRepository.save(newTwit);
        return TwitResponseDTO.of(savedTwit);
    }

    // 전체 트윗 리스트 조회
    @Transactional(readOnly = true)
    public TwitListResponseDTO getTwitList() {
        List<Twit> twits = twitRepository.findAll();
        return TwitListResponseDTO.from(twits);
    }

    // 상세 트윗 조회
    @Transactional(readOnly = true)
    public TwitResponseDTO getTwit(Long twit_id) {
        Twit twit = twitRepository. findById(twit_id)
                .orElseThrow(() -> new RuntimeException("Twit not found"));
        return TwitResponseDTO.of(twit);
    }

    // 트윗 삭제
    public String deleteTwit(Long twit_id) {
        if (!twitRepository.existsById(twit_id)) {
            throw new IllegalArgumentException("해당 트윗이 존재하지 않습니다: " + twit_id);
        }

        twitRepository.deleteById(twit_id);
        return "트윗이 성공적으로 삭제되었습니다.";
    }
}
