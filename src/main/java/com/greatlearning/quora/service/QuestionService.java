package com.greatlearning.quora.service;

import com.greatlearning.quora.error.EntityNotFoundException;
import com.greatlearning.quora.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> getAllQuestion();

    Question createQuestion(Question question);

    Question updateQuestion(Question question) throws EntityNotFoundException;

    Optional<Question> getQuestion(Long questionId) throws EntityNotFoundException;
}
