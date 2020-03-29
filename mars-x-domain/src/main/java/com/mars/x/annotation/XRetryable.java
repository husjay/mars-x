package com.mars.x.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface XRetryable {

    Class<? extends Throwable>[] value() default {};

    int maxAttempts() default 3;
}
