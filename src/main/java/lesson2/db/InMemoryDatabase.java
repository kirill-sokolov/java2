package lesson2.db;

import lesson2.domain.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements TodoRepository {

    private List<Todo> todos = new ArrayList<>();

    @Override
    public void save(Todo todo) {
        todos.add(todo);
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        /*for (Todo todo : todos) {
            if (todo.getTitle().equals(title)) {
                return Optional.of(todo);
            }
        }
        return Optional.empty();*/

        return todos.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst();
    }

    @Override
    public boolean remove(Todo todo) {
        return todos.remove(todo);
    }

    @Override
    public List<Todo> getAll() {
        return new ArrayList<>(todos);
    }

}