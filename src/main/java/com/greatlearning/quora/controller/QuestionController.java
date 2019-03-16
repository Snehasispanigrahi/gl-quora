package com.greatlearning.quora.controller;

import com.greatlearning.quora.error.EntityNotFoundException;
import com.greatlearning.quora.mapper.QuestionMapper;
import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.model.dto.QuestionDTO;
import com.greatlearning.quora.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping(value = "/question/all")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        List<Question> questionList = questionService.getAllQuestion();

        List<QuestionDTO> questionDTOS = questionMapper.fromQuestionList(questionList);

        return new ResponseEntity<>(questionDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/question/{questionId}")
    public ResponseEntity<QuestionDTO> getAQuestion(@PathVariable Long questionId) throws EntityNotFoundException {
        Question question = questionService.getQuestion(questionId);
        return new ResponseEntity<>(questionMapper.fromQuestion(question), HttpStatus.OK);
    }

    @PostMapping(value = "/question/create")
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody @Valid QuestionDTO questionDTO) {
        Question question = questionMapper.toQuestion(questionDTO);
        question.setCreatedOn(LocalDateTime.now());
        question = questionService.createQuestion(question);
        return new ResponseEntity<>(questionMapper.fromQuestion(question), HttpStatus.OK);
    }

    @PutMapping(value = "/question/edit/{questionId}")
    public ResponseEntity<QuestionDTO> editQuestion(@RequestBody @Valid QuestionDTO questionDTO) throws EntityNotFoundException {
        Question question = questionService.updateQuestion(questionMapper.toQuestion(questionDTO));
        return new ResponseEntity<>(questionMapper.fromQuestion(question), HttpStatus.OK);
    }
}
