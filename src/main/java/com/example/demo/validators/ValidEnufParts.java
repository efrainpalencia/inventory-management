package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = EnufPartsValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnufParts {
    String message() default "There aren't enough parts in inventory!";
    String belowMinMessage() default "Adding this product will reduce parts inventory below the minimum. Remove the part(s) and try again.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
