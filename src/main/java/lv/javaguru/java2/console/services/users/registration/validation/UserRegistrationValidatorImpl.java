package lv.javaguru.java2.console.services.users.registration.validation;

import lv.javaguru.java2.console.services.users.registration.UserRegistrationRequest;
import lv.javaguru.java2.console.services.users.registration.validation.rules.DuplicateUserLoginRule;
import lv.javaguru.java2.console.services.Error;
import lv.javaguru.java2.console.services.users.registration.validation.rules.EmptyLoginRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class UserRegistrationValidatorImpl implements UserRegistrationValidator {
    @Autowired
    private EmptyLoginRule emptyLoginRule;
    @Autowired
    private DuplicateUserLoginRule duplicateUserLoginRule;

    @Override
    public List<Error> validate(UserRegistrationRequest request) {
        List<Error> errors = new ArrayList<>();
        emptyLoginRule.execute(request.getLogin()).ifPresent(errors::add);
        duplicateUserLoginRule.execute(request.getLogin()).ifPresent(errors::add);
        return errors;
    }
}