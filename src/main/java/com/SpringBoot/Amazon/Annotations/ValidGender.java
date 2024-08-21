package com.SpringBoot.Amazon.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenderValid.class)
public @interface ValidGender {
    String message() default " Invalid Gender .......! ";
    Class<?>[] groups() default {};
    Class<? extends Payload >[] payload() default {};
}

