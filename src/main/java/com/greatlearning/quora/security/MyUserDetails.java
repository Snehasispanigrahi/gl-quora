package com.greatlearning.quora.security;

import com.greatlearning.quora.model.UserProfile;
import com.greatlearning.quora.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserProfile userProfile = userProfileRepository.findByUsername(username);

        if (userProfile == null)
            throw new UsernameNotFoundException("User: " + username + " not found");
        return User.withUsername(username)
                .password(userProfile.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .authorities(userProfile.getRoles())
                .build();
    }
}
