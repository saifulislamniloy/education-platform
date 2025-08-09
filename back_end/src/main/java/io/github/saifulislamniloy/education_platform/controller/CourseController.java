package io.github.saifulislamniloy.education_platform.controller;

import io.github.saifulislamniloy.education_platform.mapper.CourseConverter;
import io.github.saifulislamniloy.education_platform.model.dto.request.CourseRequestDTO;
import io.github.saifulislamniloy.education_platform.model.dto.response.CourseResponseDTO;
import io.github.saifulislamniloy.education_platform.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static io.github.saifulislamniloy.education_platform.constant.ApiConstant.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_VERSION)
public class CourseController {

    private final CourseService courseService;


    @PostMapping(CREATE_COURSE)
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        CourseResponseDTO courseResponseDTO = CourseConverter.toResponseDTO(
                courseService.createCourse(courseRequestDTO)
        );

        return ResponseEntity.ok(courseResponseDTO);
    }


    @GetMapping(GET_COURSE)
    public ResponseEntity<CourseResponseDTO> getCourseById(@RequestParam UUID courseId) {
        CourseResponseDTO courseResponseDTO = CourseConverter.toResponseDTO(
                courseService.getCourseById(courseId)
        );

        return ResponseEntity.ok(courseResponseDTO);
    }


    @GetMapping(SEARCH_COURSE)
    public ResponseEntity<List<CourseResponseDTO>> search() {
        List<CourseResponseDTO> courseResponseDTOList = courseService.search()
                .stream().map(CourseConverter::toResponseDTO).toList();

        return ResponseEntity.ok(courseResponseDTOList);
    }


    @PutMapping(UPDATE_COURSE)
    public ResponseEntity<CourseResponseDTO> updateCourse(
            @RequestParam UUID courseId,
            @RequestBody CourseRequestDTO courseRequestDTO
    ) {
        CourseResponseDTO courseResponseDTO = CourseConverter.toResponseDTO(
                courseService.updateCourse(courseId, courseRequestDTO)
        );

        return ResponseEntity.ok(courseResponseDTO);
    }

    @DeleteMapping(DELETE_COURSE)
    public ResponseEntity<String> deleteCourse(@RequestParam UUID courseId) {
        courseService.deleteCourse(courseId);

        return ResponseEntity.ok("Deleted course successfully");
    }
}
