package cz.cizek.edu.mvc.validator;

import cz.cizek.edu.mvc.domain.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author jiricizek <jiri.cizek@cleverlance.com>
 */
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Customer customer = (Customer) target;

        if (customer.getAge() < 18) {
            errors.rejectValue("age", "error.key", "neplnolety");
        }
    }
}
