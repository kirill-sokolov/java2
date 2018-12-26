package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    void save(Todo todo);

    Optional<Todo> findByTitle(String title);

    boolean remove(Todo todo);

    List<Todo> getAll();
    List<Todo> findListItems(Long todoListId);

}