package com.techpro.twitter.repositories;

import com.techpro.twitter.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long id);

    @Query(value = "SELECT u FROM User u WHERE u.email=:email")
    Optional<User> findByEmail(@Param("email") String email);

    @Override
    User save(User saveToUser);
}
