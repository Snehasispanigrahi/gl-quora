package com.greatlearning.quora.service.impl;

import com.greatlearning.quora.error.EntityNotFoundException;
import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.repository.QuestionRepository;
import com.greatlearning.quora.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestion() {
        List<Question> questionList = questionRepository.findAll();
        return questionList;
    }

    @Override
    public Question createQuestion(Question question) {
//        question.setUserProfile(null);
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question questionRequest) throws EntityNotFoundException {
        Optional<Question> question = getQuestion(questionRequest.getId());
        return questionRepository.save(question.get());
    }

    @Override
    public Optional<Question> getQuestion(Long questionId) throws EntityNotFoundException {
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isEmpty()) {
            throw new EntityNotFoundException(Question.class, "id", questionId.toString());
        }
        return question;
    }
}