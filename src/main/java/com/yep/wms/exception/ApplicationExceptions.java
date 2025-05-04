package com.yep.wms.exception;

import reactor.core.publisher.Mono;

public class ApplicationExceptions {
    public static <T> Mono<T> emptyName(){
        return Mono.error(new NameNotValidException());
    }

    public static <T> Mono<T> emptyDescription(){
        return Mono.error(new DescriptionIsNotValid());
    }
}
