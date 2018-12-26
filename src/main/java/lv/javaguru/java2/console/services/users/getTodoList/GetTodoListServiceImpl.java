package lv.javaguru.java2.console.services.users.getTodoList;

import lv.javaguru.java2.console.database.UserRepository;
import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.domain.User;
import lv.javaguru.java2.console.services.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class GetTodoListServiceImpl implements GetTodoListService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public GetTodoListResponse getTodoList(GetTodoListRequest request) {
        // todo: validators

        Optional<User> userOpt = userRepository.findById(request.getUserId());
        User user = userOpt.get();

        List <TodoList> todoLists = userRepository.findTodoLists(user);

        return new GetTodoListResponse(todoLists, true);

//        return userRepository.findTodoLists(user)
//                .map(GetTodoListResponse::new)
//                .orElseGet(this::buildUserNotFoundResponse);
    }

    private GetTodoListResponse buildUserNotFoundResponse() {
        Error error = new Error("user with id", "not found");
        List<Error> errors = Arrays.asList(error);
        return new GetTodoListResponse(errors);
    }
}