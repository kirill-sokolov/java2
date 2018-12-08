package lv.javaguru.java2.console.domain.builders;

import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.domain.User;

public class TodoListBuilder {

    private Long id;
    private String title;
    private User user;

    private TodoListBuilder() {}

    public static TodoListBuilder createList() {
        return new TodoListBuilder();
    }

    public TodoList build() {
        TodoList todoList = new TodoList();
        todoList.setId(id);
        todoList.setTitle(title);
        todoList.setUser(user);
        return todoList;
    }

    public TodoListBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public TodoListBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TodoListBuilder withUser(User user) {
        this.user = user;
        return this;
    }

}