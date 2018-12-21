package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    List<TodoList> findTodoLists(User user);

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long userId);

}