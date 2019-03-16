package com.greatlearning.quora.repository;

import com.greatlearning.quora.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long>, AnswerRepositoryCustom {

}
