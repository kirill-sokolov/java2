package lv.javaguru.java2.console.businesslogic.addtodo.validation;

import lv.javaguru.java2.console.businesslogic.Error;
import lv.javaguru.java2.console.businesslogic.addtodo.AddTodoRequest;

import java.util.List;

public interface AddTodoValidator {
    List<Error> validate(AddTodoRequest request);
}