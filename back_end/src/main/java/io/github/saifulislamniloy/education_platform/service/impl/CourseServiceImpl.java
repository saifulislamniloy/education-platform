package io.github.saifulislamniloy.education_platform.service.impl;

import io.github.saifulislamniloy.education_platform.mapper.CourseConverter;
import io.github.saifulislamniloy.education_platform.model.dto.request.CourseRequestDTO;
import io.github.saifulislamniloy.education_platform.model.entity.Course;
import io.github.saifulislamniloy.education_platform.repository.CourseRepository;
import io.github.saifulislamniloy.education_platform.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course createCourse(CourseRequestDTO courseRequestDTO) {
        Course entity = CourseConverter.toEntity(courseRequestDTO);
        entity.setPid(UUID.randomUUID());

        return courseRepository.save(entity);
    }

    @Override
    public Course getCourseById(UUID courseId) {
        return courseRepository.findCourseByPid(courseId);
    }

    @Override
    public List<Course> search() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(UUID courseId, CourseRequestDTO courseRequestDTO) {
        Course entity = courseRepository.findCourseByPid(courseId);

        if(courseRequestDTO.getName() != null) entity.setName(courseRequestDTO.getName());
        if(courseRequestDTO.getDescription() != null) entity.setName(courseRequestDTO.getDescription());
        if(courseRequestDTO.getBannerImageUrl() != null) entity.setName(courseRequestDTO.getBannerImageUrl());

        return courseRepository.save(entity);
    }

    @Override
    public void deleteCourse(UUID courseId) {
        Course course = courseRepository.findCourseByPid(courseId);

        courseRepository.delete(course);
    }
}
