package lv.javaguru.java2.console.businesslogic.createtodolist.validation.rules;

import lv.javaguru.java2.console.database.TodoListRepository;
import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.businesslogic.Error;
import lv.javaguru.java2.console.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DuplicateTodoListTitleRule {
    private TodoListRepository todoListRepository;

    public DuplicateTodoListTitleRule(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public Optional<Error> execute(User user, String title) {

        if (title != null) {
            Optional<TodoList> todoList = todoListRepository.findByUserAndTitle(user, title);
            if (todoList.isPresent()) {
                Error error = new Error("title", "Duplicate title not allowed");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
