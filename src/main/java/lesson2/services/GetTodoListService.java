package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTodoListService {

//    @Autowired
    private TodoRepository database;

    public GetTodoListService(TodoRepository database) {
        this.database = database;
    }

    public List<Todo> getAllTodos() {
        return database.getAll();
    }

}