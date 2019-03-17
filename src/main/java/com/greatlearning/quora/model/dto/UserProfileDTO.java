package com.greatlearning.quora.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
public class UserProfileDTO {
    @Id
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    private String name;
    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String username;
    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;
}
