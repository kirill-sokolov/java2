package lv.javaguru.java2.web.controllers;

import lv.javaguru.java2.console.domain.Todo;
import lv.javaguru.java2.console.services.todos.add.AddTodoRequest;
import lv.javaguru.java2.console.services.todos.add.AddTodoResponse;
import lv.javaguru.java2.console.services.todos.add.AddTodoService;
import lv.javaguru.java2.console.services.todos.get.GetTodoListService;
import lv.javaguru.java2.console.services.todos.remove.RemoveTodoService;
import lv.javaguru.java2.web.dtos.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private AddTodoService addTodoService;
    @Autowired
    private GetTodoListService getTodoListService;
    @Autowired
    private RemoveTodoService removeTodoService;

    @ResponseBody
    @PostMapping(value = "/user/{userId}/todoList/{todoListId}/todo")
    public ResponseEntity<TodoDTO> createTodo(@RequestBody TodoDTO todoDTO) {
        AddTodoRequest request = new AddTodoRequest(
                todoDTO.getTitle(), todoDTO.getDescription(), todoDTO.getTodoListId()
        );
        AddTodoResponse response = addTodoService.add(request);
        todoDTO.setId(response.getTodoId());
        return ResponseEntity.ok(todoDTO);
    }

    @RequestMapping(value = "/user/{userId}/todoList/{todoListId}/todo", method = RequestMethod.GET)
    public List<Todo> getTodosInTodoList(@PathVariable("userId") Long userId, @PathVariable("todoListId") Long todoListId) {
//        GetUserRequest request = new GetUserRequest(userId);
//        GetUserResponse response = getUserService.get(request);
        List<Todo> response = getTodoListService.getAllTodosByTodoListId(todoListId);
        return response;
    }
}
