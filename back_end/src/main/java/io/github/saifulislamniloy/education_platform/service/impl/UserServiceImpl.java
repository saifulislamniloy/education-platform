package io.github.saifulislamniloy.education_platform.service.impl;

import io.github.saifulislamniloy.education_platform.mapper.UserConverter;
import io.github.saifulislamniloy.education_platform.model.dto.request.UserRequestDTO;
import io.github.saifulislamniloy.education_platform.model.entity.User;
import io.github.saifulislamniloy.education_platform.repository.UserRepository;
import io.github.saifulislamniloy.education_platform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserRequestDTO userRequestDTO) {
        User entity = UserConverter.toEntity(userRequestDTO);
        entity.setPid(UUID.randomUUID());

        return userRepository.save(entity);
    }

    @Override
    public User getUserByUUID(UUID userId) {
        return userRepository.findUserByPid(userId);
    }

    @Override
    public List<User> searchUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UUID userId, UserRequestDTO userRequestDTO) {
        User entity = userRepository.findUserByPid(userId);
        entity.setName(userRequestDTO.getName());

        return userRepository.save(entity);
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = userRepository.findUserByPid(userId);
        userRepository.delete(user);
    }
}
