package com.labelledejour.api.web.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {

    private final String field;
    private final String message;

    public static List<ExceptionResponse> of(BindingResult bindingResult) {

        return bindingResult.getFieldErrors()
                .stream()
                .map(fieldError -> {
                    return ExceptionResponse.builder()
                            .field(fieldError.getField())
                            .message(fieldError.getDefaultMessage())
                            .build();
                }).collect(Collectors.toList());
    }

    public static ExceptionResponse of(String msg) {
        return ExceptionResponse.builder()
                .message(msg)
                .build();
    }
}
