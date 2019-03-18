package com.greatlearning.quora.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table
public class UserProfile {
    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String username;
    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
}
