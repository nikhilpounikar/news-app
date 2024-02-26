package com.authentication.AuthenticationService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.AuthenticationService.Models.Friendship;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    // You can add custom queries or methods related to friendships if needed
}

