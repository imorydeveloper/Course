package org.example.course.exception;

import lombok.Builder;

@Builder
public record FieldErrorResponse(
            String field,
            String detail
){

}
