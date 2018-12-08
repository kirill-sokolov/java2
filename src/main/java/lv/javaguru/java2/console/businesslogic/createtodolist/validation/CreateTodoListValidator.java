package lv.javaguru.java2.console.businesslogic.createtodolist.validation;

import lv.javaguru.java2.console.businesslogic.createtodolist.CreateTodoListRequest;
import lv.javaguru.java2.console.businesslogic.Error;
import lv.javaguru.java2.console.domain.User;

import java.util.List;

public interface CreateTodoListValidator {
    List<Error> validate(User user, CreateTodoListRequest request);
}