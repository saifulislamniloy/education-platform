package io.github.saifulislamniloy.education_platform.controller;

import io.github.saifulislamniloy.education_platform.mapper.UserConverter;
import io.github.saifulislamniloy.education_platform.model.dto.request.UserRequestDTO;
import io.github.saifulislamniloy.education_platform.model.dto.response.UserResponseDTO;
import io.github.saifulislamniloy.education_platform.model.entity.User;
import io.github.saifulislamniloy.education_platform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static io.github.saifulislamniloy.education_platform.constant.ApiConstant.*;

@RestController
@RequestMapping(API_VERSION)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = UserConverter.toResponseDTO(
                userService.createUser(userRequestDTO)
        );
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping(GET_USER)
    public ResponseEntity<UserResponseDTO> getUser(@RequestParam UUID userId) {
        UserResponseDTO userResponseDTO =  UserConverter.toResponseDTO(
                userService.getUserByUUID(userId)
        );
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping(SEARCH_USER)
    public ResponseEntity<List<UserResponseDTO>> searchUser() {
        List<UserResponseDTO> userResponseDTOList =  userService.searchUser()
                .stream().map(UserConverter::toResponseDTO).toList();
        return ResponseEntity.ok(userResponseDTOList);
    }

    @PutMapping(UPDATE_USER)
    public ResponseEntity<UserResponseDTO> updateUser(
            @RequestParam UUID userId,
            @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO =  UserConverter.toResponseDTO(
                userService.updateUser(userId, userRequestDTO)
        );
        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping(DELETE_USER)
    public ResponseEntity<String> updateUser(@RequestParam UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
