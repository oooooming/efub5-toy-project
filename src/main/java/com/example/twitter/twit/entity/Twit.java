package com.example.twitter.twit.entity;

import com.example.twitter.global.domain.BaseEntity;
import com.example.twitter.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "twits")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Twit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long twit_id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public Twit(Long twit_id, String content, Member member) {
        this.twit_id = twit_id;
        this.content = content;
        this.member = member;
    }
}
