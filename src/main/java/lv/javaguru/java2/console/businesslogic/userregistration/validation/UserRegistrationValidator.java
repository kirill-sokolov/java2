package lv.javaguru.java2.console.businesslogic.userregistration.validation;

import lv.javaguru.java2.console.businesslogic.userregistration.UserRegistrationRequest;
import lv.javaguru.java2.console.businesslogic.Error;

import java.util.List;

public interface UserRegistrationValidator {
    List<Error> validate(UserRegistrationRequest request);
}