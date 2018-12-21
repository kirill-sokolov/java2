package lv.javaguru.java2.console.services.users.registration.validation;

import lv.javaguru.java2.console.services.users.registration.UserRegistrationRequest;
import lv.javaguru.java2.console.services.Error;

import java.util.List;

public interface UserRegistrationValidator {
    List<Error> validate(UserRegistrationRequest request);
}