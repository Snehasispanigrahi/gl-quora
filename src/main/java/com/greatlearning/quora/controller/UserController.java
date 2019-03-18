package com.greatlearning.quora.controller;

import com.greatlearning.quora.mapper.ProfileMapper;
import com.greatlearning.quora.model.dto.UserProfileDTO;
import com.greatlearning.quora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileMapper profileMapper;

    @PostMapping("/signin")
    public String login(@RequestBody UserProfileDTO userProfileDTO) {
        return userService.signin(userProfileDTO.getUsername(), userProfileDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserProfileDTO userProfileDTO) {
        return userService.signup(profileMapper.toProfile(userProfileDTO));
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public UserProfileDTO search(@PathVariable String username) {
        return profileMapper.fromProfile(userService.searchByUserName(username));
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<UserProfileDTO> whoami(HttpServletRequest req) {
        System.out.println("req: " + req.getHeader("Authorization"));
        UserProfileDTO userProfileDTO = profileMapper.fromProfile(userService.whoami(req));
        return new ResponseEntity<>(userProfileDTO, HttpStatus.OK);
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }

}
