package lesson2.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// @RunWith(MockitoJUnitRunner.class)
public class AddTodoServiceTest {

    //@Mock
    private TodoRepositoryMock repositoryMock = new TodoRepositoryMock();

    //@InjectMocks
    private AddTodoService service;

    @Before
    public void init() {
        repositoryMock = new TodoRepositoryMock();
        service = new AddTodoService(repositoryMock);
    }

    @Test
    public void test() {
        assertFalse(repositoryMock.isTodoSaved());
        service.add("title", "description");
        assertTrue(repositoryMock.isTodoSaved());
    }


}