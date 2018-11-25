package lv.javaguru.java2.services;

import lv.javaguru.java2.database.jdbc.TodoRepositoryImpl;
import lv.javaguru.java2.domain.Todo;

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