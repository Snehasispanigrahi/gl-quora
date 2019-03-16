package com.greatlearning.quora.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
public class UserProfileDTO {
    @Id
    private Long id;
    @NotNull
    private String email;
    @JsonIgnore
    @NotNull
    private String password;
    private String name;
}
