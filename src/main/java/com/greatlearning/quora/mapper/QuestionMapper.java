package com.greatlearning.quora.mapper;

import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.model.dto.QuestionDTO;
import com.greatlearning.quora.service.UserService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class QuestionMapper {
    @Autowired
    UserService userService;

    public Question toQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setTitle(questionDTO.getTitle());
        question.setDescription(questionDTO.getDescription());
        question.setUserProfile(userService.getCurrentUser());
        return question;
    }

    public abstract QuestionDTO fromQuestion(Question question);

    public abstract List<Question> toQuestionList(List<QuestionDTO> questionDTOList);

    public abstract List<QuestionDTO> fromQuestionList(List<Question> questionList);
}
