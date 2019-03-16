package com.greatlearning.quora.repository;

import com.greatlearning.quora.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
