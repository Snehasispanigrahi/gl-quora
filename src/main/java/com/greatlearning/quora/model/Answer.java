package com.greatlearning.quora.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime createdOn = LocalDateTime.now();
    @NotNull
    private LocalDateTime lastUpdatedOn = LocalDateTime.now();
    @OneToOne
    @JoinColumn
    @NotNull
    private UserProfile userProfile;
}
