package fr.fidtec.contraintes;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = PaymentDateValidationImpl.class)
public @interface PaymentDateValidation {

    String message() default
    "The payment date must be at most 60 days from today.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
