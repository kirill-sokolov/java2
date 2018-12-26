package lv.javaguru.java2.console.services.users.getTodoList;

import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.services.Error;

import java.util.List;

public class GetTodoListResponse {
    private List<TodoList> todoList;

    private boolean success;

    private List<Error> errors;

    public GetTodoListResponse() {
    }

//    public interface ListTodoListRef extends Supplier<List<TodoList>> {
//    }

    public GetTodoListResponse(List<TodoList> todoList, boolean fix) {
        this.todoList = todoList;
        this.success = true;
        this.errors = null;
    }

    public GetTodoListResponse(List<Error> errors) {
        this.todoList = null;
        this.success = false;
        this.errors = errors;
    }

    public List<TodoList> getTodoList() {
        return todoList;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    //    public boolean isSuccess() {
//        return user != null && (error == null) ;
//    }
}
