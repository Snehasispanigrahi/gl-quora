package com.greatlearning.quora.model.dto;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
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
