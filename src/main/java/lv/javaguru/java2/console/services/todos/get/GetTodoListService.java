package lv.javaguru.java2.console.services.todos.get;

import lv.javaguru.java2.console.domain.Todo;
import lv.javaguru.java2.console.database.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTodoListService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.getAll();
    }

}