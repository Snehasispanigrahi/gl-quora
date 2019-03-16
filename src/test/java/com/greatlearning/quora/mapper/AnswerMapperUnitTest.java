package com.greatlearning.quora.mapper;

import com.greatlearning.quora.model.Answer;
import com.greatlearning.quora.model.UserProfile;
import com.greatlearning.quora.model.dto.AnswerDTO;
import com.greatlearning.quora.model.dto.UserProfileDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class AnswerMapperUnitTest {
    AnswerMapper answerMapper = AnswerMapper.INSTANCE;
    ProfileMapper profileMapper = ProfileMapper.INSTANCE;
    UserProfileDTO profileDTO;
    UserProfile profile;

    @Before
    public void setUp() throws Exception {
        profileDTO = new UserProfileDTO();
        profileDTO.setEmail("pani@gmail.com");
        profileDTO.setName("pani");
        profileDTO.setPassword("test");

        profile = profileMapper.toProfile(profileDTO);
    }

    @Test
    public void givenProfileDTOtoProfileEntity_whenMaps_thenCorrect() {
        assertEquals(profileDTO.getEmail(), profile.getEmail());
    }

    @Test
    public void givenAnswerDTOtoAnswerEntity_whenMaps_thenCorrect() {
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setUserProfile(profileDTO);
        answerDTO.setDescription("First Desc");

        Answer answer = answerMapper.toAnswer(answerDTO);

        assertEquals(answerDTO.getUserProfile().getEmail(), answer.getUserProfile().getEmail());
        assertEquals(answerDTO.getDescription(), answer.getDescription());
    }

    @Test
    public void givenAnswerEntitytoAnswerDTO_whenMaps_thenCorrect() {
        Answer answer = new Answer();
        answer.setUserProfile(profile);
        answer.setDescription("First Desc");

        AnswerDTO answerDTO = answerMapper.fromAnswer(answer);

        assertEquals(answerDTO.getUserProfile().getEmail(), answer.getUserProfile().getEmail());
        assertEquals(answerDTO.getDescription(), answer.getDescription());
    }
}