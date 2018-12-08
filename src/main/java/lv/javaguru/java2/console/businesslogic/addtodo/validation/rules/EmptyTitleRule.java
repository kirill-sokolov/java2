package lv.javaguru.java2.console.businesslogic.addtodo.validation.rules;

import lv.javaguru.java2.console.businesslogic.Error;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmptyTitleRule {
    public Optional<Error> execute(String title) {
        if (title == null || title.isEmpty()) {
            Error error = new Error("title", "Empty title not allowed");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}