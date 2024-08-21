package com.SpringBoot.Amazon.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class GenderValid implements ConstraintValidator<ValidGender,String> {

    private static final List<String> gender = Arrays.asList("MALE","FEMALE","OTHERS");

    @Override
    public boolean isValid(String value,ConstraintValidatorContext context) {
        return value != null && gender.contains(value);
    }

}

