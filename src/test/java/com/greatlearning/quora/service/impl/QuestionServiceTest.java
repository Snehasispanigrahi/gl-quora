package com.greatlearning.quora.service.impl;

import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.model.UserProfile;
import com.greatlearning.quora.service.QuestionService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionServiceTest {
    private Question q1;
    private Question q2;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUp() {
        UserProfile profile = new UserProfile();
        profile.setUsername("pani");
        profile.setEmail("pani@gmail.com");
        profile.setPassword("test@1234");

        entityManager.persist(profile);

        q1 = new Question();
        q1.setTitle("01 title");
        q1.setDescription("01 desc");
        q1.setUserProfile(profile);

        q2 = new Question();
        q2.setTitle("02 title");
        q2.setDescription("02 desc");
        q2.setUserProfile(profile);
    }

    @Test
    public void findAll() {
        List<Question> questionList = questionService.getAllQuestion();

        assertEquals(questionList, Matchers.containsInAnyOrder(questionList));
    }

    @Test
    public void create() {
        Question question_1 = questionService.createQuestion(q1);
        Question question_2 = questionService.createQuestion(q2);

        assertEquals(question_1, q1);
        assertEquals(question_2, q2);
    }

    @Test
    public void update() {
    }

    @Test
    public void findById() {
    }
}