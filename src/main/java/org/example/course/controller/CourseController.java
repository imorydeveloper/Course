package org.example.course.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.course.dto.*;
import org.example.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;



    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @PostMapping
    public CourseResponse createNewCourse( @Valid @RequestBody CourseCreateRequest courseRequest){
        return courseService.createNewCourse(courseRequest);
    }

    @GetMapping
    public List<CourseResponse>findAllCourse(){
       return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    public CourseResponse updateCourse(@Valid @PathVariable Integer id, @RequestBody CourseUpdateRequest courseUpdateRequest){
        return courseService.updateCourse(id, courseUpdateRequest);
    }

    @GetMapping("/{id}")
   public CourseResponse updateCourse(@PathVariable Integer id){
        return courseService.findCourseById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
}
