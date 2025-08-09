package io.github.saifulislamniloy.education_platform.mapper;

import io.github.saifulislamniloy.education_platform.model.dto.request.CourseRequestDTO;
import io.github.saifulislamniloy.education_platform.model.dto.response.CourseResponseDTO;
import io.github.saifulislamniloy.education_platform.model.entity.Course;

public class CourseConverter {

    public static Course toEntity(CourseRequestDTO courseRequestDTO) {
        return new Course(
                null,
                courseRequestDTO.getName(),
                courseRequestDTO.getDescription(),
                courseRequestDTO.getBannerImageUrl(),
                courseRequestDTO.getCourseId() == null ? null : courseRequestDTO.getCourseId()
        );
    }

    public static CourseResponseDTO toResponseDTO(Course course) {
        return new CourseResponseDTO(
                course.getName(),
                course.getDescription(),
                course.getBannerImageUrl(),
                course.getPid()
        );
    }
}
