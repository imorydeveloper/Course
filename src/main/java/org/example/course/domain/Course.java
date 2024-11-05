package org.example.course.domain;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Course {
    private Integer id;
    private String title;
    private String description;
    private BigDecimal price;
    private boolean status;
    private Instructor instructor;
}
