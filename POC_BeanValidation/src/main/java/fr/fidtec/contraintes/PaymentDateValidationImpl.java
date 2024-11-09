package fr.fidtec.contraintes;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class PaymentDateValidationImpl implements ConstraintValidator<PaymentDateValidation, Date> {

    @Override
    public void initialize(PaymentDateValidation constraintAnnotation) {
        // Initialization logic if needed
    }

    @Override
    public boolean isValid(Date paymentDate, ConstraintValidatorContext context) {
        if (paymentDate != null){
            Date lastValidDate = new Date();
            lastValidDate = DateUtils.addDays(lastValidDate, 60);

            long diffDayCount = lastValidDate.getTime() - paymentDate.getTime();
            return diffDayCount <= 60;
        }

        return true;

    }
}
