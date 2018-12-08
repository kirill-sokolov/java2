package lv.javaguru.java2.console.businesslogic.userregistration.validation.rules;

import lv.javaguru.java2.console.businesslogic.Error;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmptyLoginRule {
    public Optional<Error> execute(String login) {
        if (login == null || login.isEmpty()) {
            Error error = new Error("login", "Empty login not allowed");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}