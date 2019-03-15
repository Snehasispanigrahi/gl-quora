package com.greatlearning.quora.mapper;

import com.greatlearning.quora.dto.AnswerDTO;
import com.greatlearning.quora.model.Answer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AnswerMapper {
    Answer toAnswer(AnswerDTO AnswerDTO, @MappingTarget Answer Answer);

    @InheritInverseConfiguration
    AnswerDTO fromAnswer(Answer Answer);

    List<Answer> toAnswerList(List<AnswerDTO> AnswerDTOList);

    List<AnswerDTO> fromAnswerList(List<Answer> AnswerList);
}
