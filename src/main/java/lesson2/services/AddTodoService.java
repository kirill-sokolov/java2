package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.Database;

public class AddTodoService {

    private Database database;

    public AddTodoService(Database database) {
        this.database = database;
    }

    public void add(String title,
                    String description) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);

        database.addTodo(todo);
    }

}