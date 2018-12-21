package lv.javaguru.java2.console.services.users.registration.validation.rules;

import lv.javaguru.java2.console.services.Error;
import lv.javaguru.java2.console.database.UserRepository;
import lv.javaguru.java2.console.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DuplicateUserLoginRule {
    private UserRepository repository;

    public DuplicateUserLoginRule(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<Error> execute(String login) {
        if (login != null) {
            Optional<User> user = repository.findByLogin(login);
            if (user.isPresent()) {
                Error error = new Error("login", "Duplicate login not allowed");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}