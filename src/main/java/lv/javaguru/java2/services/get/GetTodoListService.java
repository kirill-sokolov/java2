package lv.javaguru.java2.services.get;

import lv.javaguru.java2.domain.Todo;
import lv.javaguru.java2.database.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTodoListService {

    @Autowired
    private TodoRepository database;

    public List<Todo> getAllTodos() {
        return database.getAll();
    }

}