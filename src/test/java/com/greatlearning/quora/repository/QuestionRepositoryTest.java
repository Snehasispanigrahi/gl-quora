package com.greatlearning.quora.repository;

import com.greatlearning.quora.model.Question;
import com.greatlearning.quora.model.UserProfile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    UserProfile profile;
    @Before
    public void setUp() throws Exception {
        profile = new UserProfile();
        profile.setEmail("pani@gmail.com");
        profile.setName("pani");
        profile.setPassword("test");
    }

    @Autowired
    QuestionRepository repo;

    @Test
    public void createQuestion() {
        Question question = new Question();
        question.setId(1l);
        question.setUserProfile(profile);
        question.setDescription("First Desc");
        question.setTitle("First Title");

        entityManager.persist(question);

        assertEquals(repo.findById(1l), question);
    }
}