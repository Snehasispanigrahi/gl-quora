package com.greatlearning.quora.controller;

import com.greatlearning.quora.dto.QuestionDTO;
import com.greatlearning.quora.error.EntityNotFoundException;
import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController {
    @Autowired
    QuestionService questionService;
    /*getAllQuestions
    getAQuestion
    addQuestion
    updateQuestion*/

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public List<QuestionDTO> getAllQuestions() {
        return this.questionService.findAll();
    }

    @RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
    public QuestionDTO getAQuestion(@PathVariable Long questionId) throws EntityNotFoundException {
        return this.questionService.findById(questionId).orElseThrow(() -> new EntityNotFoundException(Question.class, "questionId", questionId.toString()));
    }
}
