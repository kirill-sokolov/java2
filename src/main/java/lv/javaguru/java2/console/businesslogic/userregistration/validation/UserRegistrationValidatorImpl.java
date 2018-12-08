package lv.javaguru.java2.console.businesslogic.userregistration.validation;

import lv.javaguru.java2.console.businesslogic.userregistration.UserRegistrationRequest;
import lv.javaguru.java2.console.businesslogic.userregistration.validation.rules.DuplicateUserLoginRule;
import lv.javaguru.java2.console.businesslogic.Error;
import lv.javaguru.java2.console.businesslogic.userregistration.validation.rules.EmptyLoginRule;
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