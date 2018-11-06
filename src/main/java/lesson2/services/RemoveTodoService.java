package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.TodoRepository;

import java.util.Optional;

public class RemoveTodoService {

    private TodoRepository database;

    public RemoveTodoService(TodoRepository database) {
        this.database = database;
    }

    public boolean remove(String title) {
        Optional<Todo> foundTodo = database.findByTitle(title);
        if (foundTodo.isPresent()) {
            Todo todo = foundTodo.get();
            return database.remove(todo);
        } else {
            return false;
        }
    }

}