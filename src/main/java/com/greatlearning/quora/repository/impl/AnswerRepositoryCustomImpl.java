package com.greatlearning.quora.repository.impl;

import com.greatlearning.quora.model.Answer;
import com.greatlearning.quora.repository.AnswerRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AnswerRepositoryCustomImpl implements AnswerRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Answer> getAllAnswersToQuestion(Long questionId) {
        try {
            return entityManager.createNamedQuery("answersByQuestion", Answer.class).setParameter("questionId", questionId).getResultList();
        } catch (NoResultException nre) {
            return List.of();
        }
    }
}
