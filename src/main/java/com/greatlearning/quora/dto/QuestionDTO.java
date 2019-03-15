package com.greatlearning.quora.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class QuestionDTO {
    @Id
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private UserProfileDTO userProfileDTO;
}
