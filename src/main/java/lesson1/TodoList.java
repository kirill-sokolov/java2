package lesson1;

import java.util.HashSet;
import java.util.Scanner;

public class TodoList {
    private HashSet<ToDo> todos;

    TodoList() {
        todos = new HashSet<>();
    }

    public void add(ToDo todo) {
        todos.add(todo);
    }

    public void delete(ToDo todo) {
        todos.remove(todo);
    }

    public void print() {
        System.out.println("TodoList: " + todos);
        System.out.println("Size: " + todos.size());
    }
}
