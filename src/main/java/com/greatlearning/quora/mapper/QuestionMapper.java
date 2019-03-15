package com.greatlearning.quora.mapper;

import com.greatlearning.quora.dto.QuestionDTO;
import com.greatlearning.quora.model.Question;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    Question toQuestion(QuestionDTO questionDTO);

    @InheritInverseConfiguration
    QuestionDTO fromQuestion(Question question);

    List<Question> toQuestionList(List<QuestionDTO> questionDTOList);

    List<QuestionDTO> fromQuestionList(List<Question> questionList);
}
