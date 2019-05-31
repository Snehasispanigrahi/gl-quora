package com.greatlearning.quora.repository;

import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.model.UserProfile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryTest {
    UserProfile profile;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        profile = new UserProfile();
        profile.setEmail("pani@gmail.com");
        profile.setUsername("pani");
        profile.setPassword("test");

        entityManager.persist(profile);
    }

    @Test
    public void createQuestion() {
        Question question = new Question();
        question.setUserProfile(profile);
        question.setDescription("First Desc");
        question.setTitle("First Title");

        Question savedQns = questionRepository.save(question);
        assertEquals(questionRepository.findById(savedQns.getId()).orElse(null), question);
    }
}