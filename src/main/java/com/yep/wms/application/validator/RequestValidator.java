package com.yep.wms.application.validator;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.yep.wms.application.dto.ProjectRequestDto;
import com.yep.wms.exception.ApplicationExceptions;
import reactor.core.publisher.Mono;

public class RequestValidator {

    public static UnaryOperator<Mono<ProjectRequestDto>> validateProjectRequestDto(){
        return projectRequestMono -> projectRequestMono.filter(hasName())
                .switchIfEmpty(ApplicationExceptions.emptyName())
                .filter(hasDescription())
                .switchIfEmpty(ApplicationExceptions.emptyDescription());
    }
    private static Predicate<ProjectRequestDto> hasName(){
        return projectRequestDto -> Objects.nonNull(projectRequestDto.getName());
    }

    private static Predicate<ProjectRequestDto> hasDescription(){
        return projectRequestDto -> Objects.nonNull(projectRequestDto.getDescription());
    }
}
