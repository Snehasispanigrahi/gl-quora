package com.greatlearning.quora.service;

import com.greatlearning.quora.model.UserProfile;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    public String signin(String username, String password);

    public String signup(UserProfile userProfile);

    public UserProfile searchByUserName(String username);

    public UserProfile whoami(HttpServletRequest httpServletRequest);

    public String refresh(String username);
}
