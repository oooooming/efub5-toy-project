package com.example.twitter.twit.repository;

import com.example.twitter.twit.entity.Twit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwitRepository extends JpaRepository<Twit, Long> {
}
