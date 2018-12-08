package lv.javaguru.java2.console.businesslogic.addtodo.validation;

import lv.javaguru.java2.console.businesslogic.Error;
import lv.javaguru.java2.console.businesslogic.addtodo.AddTodoRequest;
import lv.javaguru.java2.console.businesslogic.addtodo.validation.rules.DuplicateTodoTitleRule;
import lv.javaguru.java2.console.businesslogic.addtodo.validation.rules.EmptyTitleRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class AddTodoValidatorImpl implements AddTodoValidator {
    @Autowired
    private EmptyTitleRule emptyTitleRule;
    @Autowired
    private DuplicateTodoTitleRule duplicateTodoTitleRule;

    @Override
    public List<Error> validate(AddTodoRequest request) {
        List<Error> errors = new ArrayList<>();
        emptyTitleRule.execute(request.getTitle()).ifPresent(errors::add);
/*
        emptyTitleRule.execute(request.getTitle()).ifPresent(new Consumer<Error>() {
            @Override
            public void accept(Error error) {
                errors.add(error);
            }
        });
*/
         /*Optional<Error> errorOpt = emptyTitleRule.execute(request.getTitle());
        if (errorOpt.isPresent()) {
            Error error = errorOpt.get();
            errors.add(error);
        }
        */
        duplicateTodoTitleRule.execute(request.getTitle()).ifPresent(errors::add);
        return errors;
    }
}