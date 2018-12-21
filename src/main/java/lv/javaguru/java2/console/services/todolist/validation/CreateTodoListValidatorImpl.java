package lv.javaguru.java2.console.services.todolist.validation;

import lv.javaguru.java2.console.services.todos.add.validation.rules.EmptyTitleRule;
import lv.javaguru.java2.console.services.todolist.CreateTodoListRequest;
import lv.javaguru.java2.console.services.Error;
import lv.javaguru.java2.console.services.todolist.validation.rules.DuplicateTodoListTitleRule;
import lv.javaguru.java2.console.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class CreateTodoListValidatorImpl implements CreateTodoListValidator {
    @Autowired private EmptyTitleRule emptyTitleRule;
    @Autowired private DuplicateTodoListTitleRule duplicateTodoListTitleRule;

    @Override
    public List<Error> validate(User user, CreateTodoListRequest request) {
        List<Error> errors = new ArrayList<>();
        emptyTitleRule.execute(request.getTitle()).ifPresent(errors::add);
        duplicateTodoListTitleRule.execute(user, request.getTitle()).ifPresent(errors::add);
        return errors;
    }
}