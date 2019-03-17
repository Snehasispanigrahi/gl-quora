package com.greatlearning.quora.service.impl;

import com.greatlearning.quora.error.GenericException;
import com.greatlearning.quora.model.UserProfile;
import com.greatlearning.quora.repository.UserProfileRepository;
import com.greatlearning.quora.security.JwtTokenProvider;
import com.greatlearning.quora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username);
        } catch (AuthenticationException ae) {
            throw new GenericException("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public String signup(UserProfile userProfile) {
        if (!userProfileRepository.existsByUsername(userProfile.getUsername())) {
            String encoded = passwordEncoder.encode(userProfile.getPassword());
            userProfile.setPassword(encoded);
            userProfileRepository.save(userProfile);
            return jwtTokenProvider.createToken(userProfile.getUsername());
        } else {
            throw new GenericException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @Override
    public UserProfile searchByUserName(String username) {
        UserProfile userProfile = userProfileRepository.findByUsername(username);
        if (userProfile == null) {
            throw new GenericException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return userProfile;
    }

    @Override
    public UserProfile whoami(HttpServletRequest httpServletRequest) {
        return userProfileRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(httpServletRequest)));

    }

    @Override
    public String refresh(String username) {
        return jwtTokenProvider.createToken(username);
    }
}
