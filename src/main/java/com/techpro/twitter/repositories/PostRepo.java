package com.techpro.twitter.repositories;

import com.techpro.twitter.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    @Query("Select p From Post p Where p.user.id = :userId")
    List<Post> findAllByUser_id(Long userId);

    @Override
    Post save(Post post);

    @Override
    Optional<Post> findById(Long id);
}
