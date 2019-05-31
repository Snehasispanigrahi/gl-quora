package com.greatlearning.quora.service;

import com.greatlearning.quora.model.UserProfile;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String signin(String username, String password);

    String signup(UserProfile userProfile);

    UserProfile searchByUserName(String username);

    UserProfile whoami(HttpServletRequest httpServletRequest);

    String refresh(String username);

    UserProfile getCurrentUser();
}
