package lv.javaguru.java2.console.services.todos.add.validation.rules;

import lv.javaguru.java2.console.services.Error;
import lv.javaguru.java2.console.database.TodoRepository;
import lv.javaguru.java2.console.domain.Todo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DuplicateTodoTitleRule {
    private TodoRepository repository;

    public DuplicateTodoTitleRule(TodoRepository repository) {
        this.repository = repository;
    }

    public Optional<Error> execute(String title) {
        if (title != null) {
            Optional<Todo> todo = repository.findByTitle(title);
            if (todo.isPresent()) {
                Error error = new Error("title", "Duplicate title not allowed");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}