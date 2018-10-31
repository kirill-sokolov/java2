package lesson2.db;

import lesson2.domain.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database {

    private List<Todo> todos = new ArrayList<>();

    @Override
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    @Override
    public Optional<Todo> findTodoByTitle(String title) {
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
    public boolean deleteTodo(Todo todo) {
        return todos.remove(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos);
    }

}