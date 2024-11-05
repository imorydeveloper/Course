package org.example.course.repository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.course.domain.Course;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Repository
@Data
public class CourseRepository {
    private List<Course> courses;
    private InstructorRepository instructorRepository;
    public Integer getLastId() {
            return courses.getLast().getId();
    }
    public CourseRepository(InstructorRepository instructorRepository){
        this.instructorRepository = instructorRepository;

        courses = new ArrayList<>();
        courses.add(Course.builder().
                id(1).title("Java").description("Java programming").price(BigDecimal.valueOf(120.00)).status(true).instructor(instructorRepository.getInstructors().get(1)).
        build());
        courses.add(Course.builder().
                id(2).title("C#").description("C# Programming").price(BigDecimal.valueOf(110.00)).status(true).instructor(instructorRepository.getInstructors().get(0)).
        build());
        courses.add(Course.builder().
                id(3).title("HTML").description("HyperText MarkUp Language").price(BigDecimal.valueOf(100.00)).status(true).instructor(instructorRepository.getInstructors().get(0)).
        build());
    }


}