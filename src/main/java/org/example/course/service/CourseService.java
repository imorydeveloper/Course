package org.example.course.service;



import org.example.course.dto.*;

import java.util.List;


public interface CourseService {
    CourseResponse createNewCourse(CourseCreateRequest courseRequest);

    List<CourseResponse> getAllCourses();
    CourseResponse updateCourse(Integer id,CourseUpdateRequest courseUpdateRequest);

    CourseResponse findCourseById(Integer id);
    void deleteCourse(Integer id);
}
