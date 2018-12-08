package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.domain.User;

import java.util.Optional;

public interface TodoListRepository {

    void save(TodoList todoList);

    Optional<TodoList> findByUserAndTitle(User user, String title);

}