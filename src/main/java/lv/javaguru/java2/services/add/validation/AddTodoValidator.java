package lv.javaguru.java2.services.add.validation;

import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.add.AddTodoRequest;

import java.util.List;

public interface AddTodoValidator {
    List<Error> validate(AddTodoRequest request);
}