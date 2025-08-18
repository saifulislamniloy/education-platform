package io.github.saifulislamniloy.education_platform.controller;

import io.github.saifulislamniloy.education_platform.mapper.CourseConverter;
import io.github.saifulislamniloy.education_platform.model.dto.request.CourseRequestDTO;
import io.github.saifulislamniloy.education_platform.model.dto.response.CourseResponseDTO;
import io.github.saifulislamniloy.education_platform.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static io.github.saifulislamniloy.education_platform.constant.ApiConstant.*;
import static io.github.saifulislamniloy.education_platform.constant.SwaggerConstant.MetaData.*;
import static io.github.saifulislamniloy.education_platform.constant.SwaggerConstant.CourseController.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_VERSION)
public class CourseController {

    private final CourseService courseService;


    @Operation(
            summary = SaveCourse.SUMMARY,
            description = SaveCourse.DESCRIPTION,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = MEDIA_TYPE_JSON,
                            schema = @Schema(implementation = CourseRequestDTO.class),
                            examples = {
                                    @ExampleObject(name = SaveCourse.OPERATING_SYSTEM, value = SaveCourse.OPERATING_SYSTEM_VALUE),
                                    @ExampleObject(name = SaveCourse.DATABASE, value = SaveCourse.DATABASE_VALUE)
                            }
                    )
            ),
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = HTTP_OK_CODE,
                            description = HTTP_OK_DESCRIPTION,
                            content = @Content(
                                    mediaType = MEDIA_TYPE_JSON,
                                    schema = @Schema(implementation = CourseResponseDTO.class)
                            )
                    ),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = HTTP_INTERNAL_SERVER_ERROR_CODE,
                            description = HTTP_INTERNAL_SERVER_ERROR,
                            content = @Content()
                    )
            }
    )
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
