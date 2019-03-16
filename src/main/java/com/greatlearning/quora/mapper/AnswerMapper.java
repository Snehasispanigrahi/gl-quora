package com.greatlearning.quora.mapper;

import com.greatlearning.quora.model.Answer;
import com.greatlearning.quora.model.dto.AnswerDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    Answer toAnswer(AnswerDTO AnswerDTO);

    @InheritInverseConfiguration
    AnswerDTO fromAnswer(Answer Answer);

    List<Answer> toAnswerList(List<AnswerDTO> AnswerDTOList);

    List<AnswerDTO> fromAnswerList(List<Answer> AnswerList);
}
