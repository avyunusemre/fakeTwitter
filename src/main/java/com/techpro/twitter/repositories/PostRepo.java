package com.techpro.twitter.repositories;

import com.techpro.twitter.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllByUser_id(Long userId);

    @Override
    Post save(Post post);

    @Override
    Optional<Post> findById(Long id);
}
