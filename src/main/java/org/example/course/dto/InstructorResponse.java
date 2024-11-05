package org.example.course.dto;

import lombok.Builder;
@Builder
public record InstructorResponse(
         Integer id,
         String name,
         String gender,
         String biography

) {
}
