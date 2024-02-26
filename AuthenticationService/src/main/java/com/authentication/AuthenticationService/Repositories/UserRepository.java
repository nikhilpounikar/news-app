package com.authentication.AuthenticationService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.AuthenticationService.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

