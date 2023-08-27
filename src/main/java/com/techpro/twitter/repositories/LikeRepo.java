package com.techpro.twitter.repositories;

import com.techpro.twitter.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepo extends JpaRepository<Like, Long> {

}
