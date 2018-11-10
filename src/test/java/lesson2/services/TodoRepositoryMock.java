package lesson2.services;

import lesson2.db.jdbc.TodoRepositoryImpl;
import lesson2.domain.Todo;

public class TodoRepositoryMock extends TodoRepositoryImpl {

    private boolean isTodoSaved = false;

    @Override
    public void save(Todo todo) {
        isTodoSaved = true;
    }

    public boolean isTodoSaved() {
        return isTodoSaved;
    }

}