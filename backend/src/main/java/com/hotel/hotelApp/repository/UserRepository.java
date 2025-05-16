package com.hotel.hotelApp.repository;

import com.hotel.hotelApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByLogin(String login);

    @Query("SELECT u FROM User u WHERE u.email = :loginOrEmail OR u.login = :loginOrEmail")
    Optional<User> findByLoginOrEmail(@Param("loginOrEmail") String loginOrEmail);

    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
}
