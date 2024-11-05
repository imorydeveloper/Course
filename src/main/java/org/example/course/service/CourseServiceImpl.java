package org.example.course.service;

import lombok.RequiredArgsConstructor;
import org.example.course.domain.Course;
import org.example.course.dto.*;
import org.example.course.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    //private final I
    @Override
    public CourseResponse createNewCourse(CourseCreateRequest courseRequest) {
        //DTO pattern
        Course newCourse = Course.builder()

                .id(courseRepository.getLastId()+1)
                .title(courseRequest.title())
                .description(courseRequest.description())
                .price(courseRequest.price())
                .status(true)
                .build();
        courseRepository.getCourses().add(newCourse);

        return CourseResponse.builder()
                .id(newCourse.getId())
                .title(newCourse.getTitle())
                .description(newCourse.getDescription())
                .price(newCourse.getPrice())
                .build();

    }
    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.getCourses().stream()
                .map(course -> CourseResponse.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .description(course.getDescription())
                    .price(course.getPrice())
                    .instructorResponse(InstructorResponse.builder()
                            .id(course.getInstructor().getId())
                            .name(course.getInstructor().getName())
                            .gender(course.getInstructor().getGender())
                            .biography(course.getInstructor().getBiography())
                            .build())
                    .build()).toList();
    }

    @Override
    public CourseResponse updateCourse(Integer id, CourseUpdateRequest courseUpdateRequest) {
        Course updateCourse = courseRepository.getCourses()
                .stream()
                .filter(course -> course.getId().equals(id))
                .peek(course -> {
                    course.setTitle(courseUpdateRequest.title());
                    course.setDescription(courseUpdateRequest.description());
                    course.setPrice(courseUpdateRequest.price());
                })
                .findFirst()//retrieve the course
                .orElseThrow();// throw an exception if the course not found
        return CourseResponse.builder()
                .id(updateCourse.getId())
                .title(updateCourse.getTitle())
                .description(updateCourse.getDescription())
                .price(updateCourse.getPrice())
                .build();
    }

    @Override
    public CourseResponse findCourseById(Integer id) {
        return courseRepository.getCourses()
                .stream().filter(course ->course.getId().equals(id))
                .map(course -> CourseResponse.builder()
                        .id(course.getId())
                        .title(course.getTitle())
                        .description(course.getDescription())
                        .price(course.getPrice())
                        .instructorResponse(InstructorResponse.builder()
                                .id(course.getInstructor().getId())
                                .name(course.getInstructor().getName())
                                .gender(course.getInstructor().getGender())
                                .biography(course.getInstructor().getBiography())
                        .build())
                .build())
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Course with id %d not found",id)));
    }


    @Override
    public void deleteCourse(Integer id) {
        List<Course> newCourse = courseRepository.getCourses()
                .stream().filter(course -> !course.getId().equals(id))
                .toList();
        courseRepository.setCourses(newCourse);
    }


}
