package com.greatlearning.quora.model.dto;

import com.greatlearning.quora.model.Role;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class UserProfileDTO {
    private Long id;
    private String email;
    private String name;
    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    private String username;
    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;
    List<Role> roles;
}
