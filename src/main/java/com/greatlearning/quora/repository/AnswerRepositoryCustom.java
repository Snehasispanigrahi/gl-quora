package com.greatlearning.quora.repository;

import com.greatlearning.quora.model.Answer;

import java.util.List;

public interface AnswerRepositoryCustom {

    List<Answer> getAllAnswersToQuestion(Long questionId);

}
