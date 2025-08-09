package io.github.saifulislamniloy.education_platform.service;

import io.github.saifulislamniloy.education_platform.model.dto.request.CourseRequestDTO;
import io.github.saifulislamniloy.education_platform.model.entity.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    Course createCourse(CourseRequestDTO courseRequestDTO);

    Course getCourseById(UUID courseId);

    List<Course> search();

    Course updateCourse(UUID courseId, CourseRequestDTO courseRequestDTO);

    void deleteCourse(UUID courseId);

}
