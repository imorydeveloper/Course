package org.example.course.dto;

import java.math.BigDecimal;

public record CourseUpdateRequest(String title, String description, BigDecimal price) {

}
