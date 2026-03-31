package org.example.java6nsp26sd20303.repository;

import org.example.java6nsp26sd20303.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByEmail(String email);

    Boolean existsByUsernameOrEmail(String username, String email);
}
