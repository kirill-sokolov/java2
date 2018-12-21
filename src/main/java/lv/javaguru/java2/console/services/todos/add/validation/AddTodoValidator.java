package lv.javaguru.java2.console.services.todos.add.validation;

import lv.javaguru.java2.console.services.Error;
import lv.javaguru.java2.console.services.todos.add.AddTodoRequest;

import java.util.List;

public interface AddTodoValidator {
    List<Error> validate(AddTodoRequest request);
}