package io.github.saifulislamniloy.education_platform.mapper;

import io.github.saifulislamniloy.education_platform.model.dto.request.UserRequestDTO;
import io.github.saifulislamniloy.education_platform.model.dto.response.UserResponseDTO;
import io.github.saifulislamniloy.education_platform.model.entity.User;

public class UserConverter {
    public static User toEntity(UserRequestDTO userRequestDTO) {
        return new User(
                null,
                userRequestDTO.getName(),
                null
        );
    }

    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getName(),
                user.getPid()
        );
    }
}
