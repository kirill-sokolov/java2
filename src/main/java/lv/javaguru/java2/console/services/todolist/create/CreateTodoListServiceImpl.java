package lv.javaguru.java2.console.services.todolist.create;

import lv.javaguru.java2.console.services.Error;
import lv.javaguru.java2.console.services.todolist.create.validation.CreateTodoListValidator;
import lv.javaguru.java2.console.database.TodoListRepository;
import lv.javaguru.java2.console.database.UserRepository;
import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static lv.javaguru.java2.console.domain.builders.TodoListBuilder.createList;

@Component
public class CreateTodoListServiceImpl implements CreateTodoListService {

    @Autowired private CreateTodoListValidator validator;
    @Autowired private TodoListRepository todoListRepository;
    @Autowired private UserRepository userRepository;

    @Override
    @Transactional
    public CreateTodoListResponse create(CreateTodoListRequest request) {
        // find user
        Optional<User> userOpt = userRepository.findByLogin(request.getUserLogin());
//        if (!userOpt.isPresent()) {
//            return new CreateTodoListResponse(buildErrorListWithUserNotFoundError());
//        }
        User user = userOpt.get();

        // validate login and password
        List<Error> validationErrors = validator.validate(user, request);
        if (!validationErrors.isEmpty()) {
            return new CreateTodoListResponse(validationErrors);
        }

        // create new todo list
        TodoList todoList = createList()
                .withTitle(request.getTitle())
                .withUser(user)
                .build();

        // store to db
        todoListRepository.save(todoList);

        return new CreateTodoListResponse(todoList.getId());
    }

}