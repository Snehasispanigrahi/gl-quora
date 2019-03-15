package com.greatlearning.quora.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class AnswerDTO {
    @Id
    private Long id;
    @NotNull(message = "Answer must be specified")
    private String description;
    @NotNull(message = "Answer should be associated to a question")
    private QuestionDTO question;
    @NotNull
    private UserProfileDTO userProfile;
}
