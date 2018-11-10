package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveTodoService {

//    @Autowired
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