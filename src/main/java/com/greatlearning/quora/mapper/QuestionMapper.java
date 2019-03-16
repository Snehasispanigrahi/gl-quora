package com.greatlearning.quora.mapper;

import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.model.dto.QuestionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question toQuestion(QuestionDTO questionDTO);

    QuestionDTO fromQuestion(Question question);

    List<Question> toQuestionList(List<QuestionDTO> questionDTOList);

    List<QuestionDTO> fromQuestionList(List<Question> questionList);
}
