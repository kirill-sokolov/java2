package lv.javaguru.java2.console.services.todolist.validation;

import lv.javaguru.java2.console.services.todolist.CreateTodoListRequest;
import lv.javaguru.java2.console.services.Error;
import lv.javaguru.java2.console.domain.User;

import java.util.List;

public interface CreateTodoListValidator {
    List<Error> validate(User user, CreateTodoListRequest request);
}