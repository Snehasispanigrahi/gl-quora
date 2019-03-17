package com.greatlearning.quora.repository;

import com.greatlearning.quora.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    boolean existsByUsername(String username);

    UserProfile findByUsername(String username);
}
