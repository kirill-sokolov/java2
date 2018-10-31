package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.Database;

import java.util.Optional;

public class RemoveTodoService {

    private Database database;

    public RemoveTodoService(Database database) {
        this.database = database;
    }

    public boolean remove(String title) {
        Optional<Todo> foundTodo = database.findTodoByTitle(title);
        if (foundTodo.isPresent()) {
            Todo todo = foundTodo.get();
            return database.deleteTodo(todo);
        } else {
            return false;
        }
    }

}