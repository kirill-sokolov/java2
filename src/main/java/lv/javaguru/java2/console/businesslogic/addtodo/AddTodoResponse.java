package lv.javaguru.java2.console.businesslogic.addtodo;

import lv.javaguru.java2.console.businesslogic.Error;

import java.util.List;

public class AddTodoResponse {
    private Long todoId;
    private List<Error> errors;

    public AddTodoResponse(Long todoId) {
        this.todoId = todoId;
    }

    public AddTodoResponse(List<Error> errors) {
        this.errors = errors;
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public boolean isSuccess() {
        return todoId != null
                && (errors == null || errors.isEmpty());
    }
}