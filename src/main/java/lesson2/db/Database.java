package lesson2.db;

import lesson2.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface Database {

    void addTodo(Todo todo);

    Optional<Todo> findTodoByTitle(String title);

    boolean deleteTodo(Todo todo);

    List<Todo> getAllTodos();

}