package org.example.course.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    private Integer id;
    private String name;
    private String gender;
    private String biography;

    private List<Course> courses;

}
