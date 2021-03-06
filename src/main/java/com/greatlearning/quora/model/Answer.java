package com.greatlearning.quora.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime createdOn = LocalDateTime.now();
    @NotNull
    private LocalDateTime lastUpdatedOn = LocalDateTime.now();
    @ManyToOne
    @JoinColumn
    @NotNull
    private Question question;
    @ManyToOne
    @JoinColumn
    @NotNull
    private UserProfile userProfile;
}
