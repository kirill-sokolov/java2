package lesson2.db;

import lesson2.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    void save(Todo todo);

    Optional<Todo> findByTitle(String title);

    boolean remove(Todo todo);

    List<Todo> getAll();

}