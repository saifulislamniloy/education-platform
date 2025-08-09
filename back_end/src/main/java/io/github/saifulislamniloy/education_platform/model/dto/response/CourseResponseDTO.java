package io.github.saifulislamniloy.education_platform.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CourseResponseDTO {
    private String name;
    private String description;
    private String bannerImageUrl;
    private UUID courseId;
}
