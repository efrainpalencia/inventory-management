package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class DeletePartValidator implements ConstraintValidator<ValidDeletePart, Part> {
    @Override
    public void initialize(final ValidDeletePart constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final Part part, final ConstraintValidatorContext constraintValidatorContext) {
        return part.getProducts().isEmpty();
    }
}
