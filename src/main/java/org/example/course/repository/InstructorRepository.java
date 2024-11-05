package org.example.course.repository;


import lombok.Getter;
import lombok.Setter;
import org.example.course.domain.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class InstructorRepository {
    private List<Instructor>instructors;
    public Integer getLastId(){
        return instructors.getLast().getId();
    }

    public InstructorRepository( ){
        instructors = new ArrayList<>();
        instructors.add(Instructor.builder()
                .id(1)
                .name("Hai")
                .gender("Male")
                .biography("Instructor of spring boot framework since 2005")
                .build());
        instructors.add(Instructor.builder()
                .id(2)
                .name("Yov")
                .gender("Male")
                .biography("Instructor of spring boot framework since 2006")
                .build());
        instructors.add(Instructor.builder()
                .id(3)
                .name("Channa")
                .gender("Male")
                .biography("Instructor of spring boot framework since 2007")
                .build());
    }
}
