package io.github.saifulislamniloy.education_platform.service;

import io.github.saifulislamniloy.education_platform.model.dto.request.UserRequestDTO;
import io.github.saifulislamniloy.education_platform.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createUser(UserRequestDTO userRequestDTO);

    User getUserByUUID(UUID userId);

    List<User> searchUser();

    User updateUser(UUID userId, UserRequestDTO userRequestDTO);

    void deleteUser(UUID userId);
}
