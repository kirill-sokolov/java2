package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.TodoRepository;

public class AddTodoService {

    private TodoRepository database;

    public AddTodoService(TodoRepository database) {
        this.database = database;
    }

    public void add(String title,
                    String description) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);

        database.save(todo);
    }

}