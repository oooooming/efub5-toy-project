package com.example.twitter.member.repository;

import com.example.twitter.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByAccount(String account);
}
