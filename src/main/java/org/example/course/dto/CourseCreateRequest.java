package org.example.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CourseCreateRequest(

        @NotBlank(message = "Tile is required")
         String title,
        String description,
        @NotNull
        @Positive
        BigDecimal price) {

}
