package com.techpro.twitter.repositories;

import com.techpro.twitter.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepo extends JpaRepository<Like, Long> {
    List<Like> findAllByPost_id(Long postId);
}
