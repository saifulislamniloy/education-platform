package io.github.saifulislamniloy.education_platform.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private String name;

    private UUID userId;
}
