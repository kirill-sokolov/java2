package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.TodoRepository;

import java.util.List;

public class GetTodoListService {

    private TodoRepository database;

    public GetTodoListService(TodoRepository database) {
        this.database = database;
    }

    public List<Todo> getAllTodos() {
        return database.getAll();
    }

}