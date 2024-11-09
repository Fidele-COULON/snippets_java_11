package fidtec.fr;

import fr.fidtec.beans.UserNotNull;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

// https://www.baeldung.com/java-notnull-method-parameter
// https://medium.com/@tanersahin/java-bean-validation-with-javax-validation-5c11d9ebc409
// https://www.baeldung.com/java-bean-validation-not-null-empty-blank
// https://www.baeldung.com/javax-validation-method-constraints
class UserNotNullTest {

    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        // validator = Validation.buildDefaultValidatorFactory().getValidator();

        // https://stackoverflow.com/questions/24386771/javax-validation-validationexception-hv000183-unable-to-load-javax-el-express
        validator =
                Validation.byDefaultProvider()
                        .configure()
                        .messageInterpolator(new ParameterMessageInterpolator())
                        .buildValidatorFactory()
                        .getValidator();

    }

    @Test
    void createUserNotNullOK() {
        UserNotNull userNotNull = new UserNotNull("toto");
        assertNotNull(userNotNull);
    }

    // sans appel à validator.validate(userNotNull), rien ne se passe
    @Test
    void createUserNotNullKO1() {
        UserNotNull userNotNull = new UserNotNull(null);
        System.out.println("Nom : " + userNotNull.getName());
        assertNotNull(userNotNull);

        userNotNull.setName(null);
        assertNotNull(userNotNull);
    }

    // l'appel à validator.validate(userNotNull) déclenche la vérification des contraintes
    // This is great, but having to add a call to our validator inside every annotated method results in a lot of boilerplate.
    // Fortunately, there’s a much simpler approach that we can use in our Spring Boot applications.
    @Test
    void createUserNotNullOK2() {
        UserNotNull userNotNull = new UserNotNull(null);
        Set<ConstraintViolation<UserNotNull>> violations = validator.validate(userNotNull);
        assertEquals(1, violations.size());
    }

    @Test
    void createUserNotNullKO2() {
        UserNotNull userNotNull = new UserNotNull(null);
        Set<ConstraintViolation<UserNotNull>> violations = validator.validate(userNotNull);
        System.out.println("violations : " + violations.size());
        assertNotEquals(0, violations.size());
    }
}
