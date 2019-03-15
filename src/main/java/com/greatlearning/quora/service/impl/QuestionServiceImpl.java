package com.greatlearning.quora.service.impl;

import com.greatlearning.quora.dto.QuestionDTO;
import com.greatlearning.quora.mapper.QuestionMapper;
import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.repository.QuestionRepository;
import com.greatlearning.quora.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public List<QuestionDTO> findAll() {
        List<Question> questionList = questionRepository.findAll();
        List<QuestionDTO> questionDTOList = questionMapper.fromQuestionList(questionList);
        return questionDTOList;
    }

    @Override
    public QuestionDTO create(QuestionDTO questionDTO) {
        Question question = questionMapper.toQuestion(questionDTO);
        question.setUserProfile(null);
        questionRepository.save(question);
        return questionMapper.fromQuestion(question);
    }

    @Override
    public QuestionDTO update(QuestionDTO questionDTO) {
        Question question = questionMapper.toQuestion(questionDTO);
        return null;
    }

    @Override
    public Optional<QuestionDTO> findById(Long questionDTOId) {
        return Optional.empty();
    }
}