package lv.javaguru.java2.console.businesslogic.addtodo;

import lv.javaguru.java2.console.businesslogic.addtodo.validation.AddTodoValidator;
import lv.javaguru.java2.console.database.TodoRepository;
import lv.javaguru.java2.console.domain.Todo;
import lv.javaguru.java2.console.businesslogic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddTodoServiceImpl implements AddTodoService {
    @Autowired
    private TodoRepository todoRepository;
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
        todoRepository.save(todo);
        return new AddTodoResponse(todo.getId());
    }
}