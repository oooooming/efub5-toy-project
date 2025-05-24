package com.example.twitter.twit.controller;

import com.example.twitter.member.entity.Member;
import com.example.twitter.member.repository.MemberRepository;
import com.example.twitter.twit.dto.request.CreateTwitRequestDTO;
import com.example.twitter.twit.dto.response.TwitListResponseDTO;
import com.example.twitter.twit.dto.response.TwitResponseDTO;
import com.example.twitter.twit.entity.Twit;
import com.example.twitter.twit.service.TwitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/twits")
@RequiredArgsConstructor
public class TwitController {
    private final TwitService twitService;

    // 트윗 생성
    @PostMapping
    public ResponseEntity<TwitResponseDTO> createTwit(@RequestBody @Valid CreateTwitRequestDTO request) {
        TwitResponseDTO response = twitService.createTwit(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 전체 트윗 리스트 조회
    @GetMapping
    public ResponseEntity<TwitListResponseDTO> getTwitList() {
        TwitListResponseDTO response = twitService.getTwitList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 상세 트윗 조회
    @GetMapping("/{twit_id}")
    public ResponseEntity<TwitResponseDTO> getTwit(@PathVariable Long twit_id) {
        TwitResponseDTO response = twitService.getTwit(twit_id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 트윗 삭제
    @DeleteMapping("/{twit_id}")
    public ResponseEntity<String> deleteTwit(@PathVariable Long twit_id) {
        String response = twitService.deleteTwit(twit_id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
