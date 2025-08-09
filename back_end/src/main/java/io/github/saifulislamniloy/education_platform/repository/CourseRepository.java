package io.github.saifulislamniloy.education_platform.repository;

import io.github.saifulislamniloy.education_platform.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseByPid(UUID pid);
}
