package lv.javaguru.java2.services.remove;

import lv.javaguru.java2.domain.Todo;
import lv.javaguru.java2.database.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveTodoService {

    @Autowired
    private TodoRepository database;

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