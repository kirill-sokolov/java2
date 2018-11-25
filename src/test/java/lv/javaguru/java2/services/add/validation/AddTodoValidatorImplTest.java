package lv.javaguru.java2.services.add.validation;

import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.add.AddTodoRequest;
import lv.javaguru.java2.services.add.validation.rules.DuplicateTodoTitleRule;
import lv.javaguru.java2.services.add.validation.rules.EmptyTitleRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AddTodoValidatorImplTest {
    @Mock
    private EmptyTitleRule emptyTitleRule;
    @Mock
    private DuplicateTodoTitleRule duplicateTodoTitleRule;
    @InjectMocks
    private AddTodoValidator validator = new AddTodoValidatorImpl();

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        Mockito.when(emptyTitleRule.execute("milk"))
                .thenReturn(Optional.of(new Error("title", "des")));
        Mockito.when(duplicateTodoTitleRule.execute("milk"))
                .thenReturn(Optional.of(new Error("title", "duplicate")));
        List<Error> errors = validator.validate(
                new AddTodoRequest("milk", "desc")
        );
        assertEquals(errors.size(), 2);
    }
}