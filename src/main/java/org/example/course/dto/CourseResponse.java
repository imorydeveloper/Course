package org.example.course.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CourseResponse(Integer id, String title,String description,BigDecimal price,InstructorResponse  instructorResponse) {

}
