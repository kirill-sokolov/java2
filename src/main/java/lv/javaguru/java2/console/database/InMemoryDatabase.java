package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.Todo;

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

    @Override
    public List<Todo> findListItems(Long todoListId) {
        return new ArrayList<>(todos);
    }

}