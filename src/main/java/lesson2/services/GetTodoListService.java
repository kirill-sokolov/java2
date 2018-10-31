package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.Database;

import java.util.List;

public class GetTodoListService {

    private Database database;

    public GetTodoListService(Database database) {
        this.database = database;
    }

    public List<Todo> getAllTodos() {
        return database.getAllTodos();
    }

}