package com.greatlearning.quora.mapper;

import com.greatlearning.quora.model.UserProfile;
import com.greatlearning.quora.model.dto.UserProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    UserProfile toProfile(UserProfileDTO profileDTO);

    UserProfileDTO fromProfile(UserProfile profile);

    List<UserProfile> toProfileList(List<UserProfileDTO> profileDTOList);

    List<UserProfileDTO> fromProfileList(List<UserProfile> profileList);
}
