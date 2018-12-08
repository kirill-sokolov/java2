package lv.javaguru.java2.console.businesslogic.createtodolist;

import lv.javaguru.java2.console.businesslogic.Error;

import java.util.List;

public class CreateTodoListResponse {
    private Long todoListId;

    private boolean success;

    private List<Error> errors;

    public CreateTodoListResponse(Long todoListId) {
        this.todoListId = todoListId;
        this.success = true;
        this.errors = null;
    }

    public CreateTodoListResponse(List<Error> errors) {
        this.todoListId = null;
        this.success = false;
        this.errors = errors;
    }

    public Long getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(Long todoListId) {
        this.todoListId = todoListId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
