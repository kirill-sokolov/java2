package lv.javaguru.java2.services.add;

import lv.javaguru.java2.database.TodoRepository;
import lv.javaguru.java2.domain.Todo;
import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.add.validation.AddTodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddTodoService {
    @Autowired
    private TodoRepository repository;
    @Autowired
    private AddTodoValidator validator;

    public AddTodoResponse add(AddTodoRequest request) {
        List<Error> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddTodoResponse(errors);
        }
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        repository.save(todo);
        return new AddTodoResponse(todo.getId());
    }
}