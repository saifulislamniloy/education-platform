package io.github.saifulislamniloy.education_platform.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CourseRequestDTO {
    private String name;

    private String description;

    private String bannerImageUrl;

    private UUID courseId;
}
