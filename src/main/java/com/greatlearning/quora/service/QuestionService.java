package com.greatlearning.quora.service;

import com.greatlearning.quora.dto.QuestionDTO;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<QuestionDTO> findAll();

    QuestionDTO create(QuestionDTO questionDTO);

    QuestionDTO update(QuestionDTO questionDTO);

    Optional<QuestionDTO> findById(Long questionDTOId);
}
