package lv.javaguru.java2.console.businesslogic.addtodo.validation.rules;

import lv.javaguru.java2.console.database.TodoRepository;
import lv.javaguru.java2.console.domain.Todo;
import lv.javaguru.java2.console.businesslogic.Error;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class DuplicateTodoTitleRuleTest {
    private TodoRepository repository;
    private DuplicateTodoTitleRule rule;

    @Before
    public void init() {
        repository = Mockito.mock(TodoRepository.class);
        rule = new DuplicateTodoTitleRule(repository);
    }

    @Test
    public void shouldReturnErrorIfTodoAlreadyExistInList() {
        Todo todo = new Todo("milk");
        Mockito.when(repository.findByTitle("milk"))
                .thenReturn(Optional.of(todo));
        Optional<Error> error = rule.execute("milk");
        assertEquals(error.isPresent(), true);
        assertEquals(error.get().getField(), "title");
        assertEquals(error.get().getDescription(), "Duplicate title not allowed");
    }

    @Test
    public void shouldReturnNoErrorIfTodoNotExistInList() {
        Mockito.when(repository.findByTitle("milk"))
                .thenReturn(Optional.empty());
        Optional<Error> error = rule.execute("milk");
        assertEquals(error.isPresent(), false);
    }

    @Test
    public void shouldReturnNoErrorIfTodoTitleIsNull() {
        Optional<Error> error = rule.execute(null);
        assertEquals(error.isPresent(), false);
        Mockito.verifyZeroInteractions(repository);
    }
} 