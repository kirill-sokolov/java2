package lesson2.services;

import lesson2.domain.Todo;
import lesson2.db.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddTodoService {

    @Autowired
    private TodoRepository repository;

    public AddTodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void add(String title,
                    String description) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);

        repository.save(todo);
    }

}