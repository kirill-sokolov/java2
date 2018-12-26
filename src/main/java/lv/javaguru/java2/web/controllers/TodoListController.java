package lv.javaguru.java2.web.controllers;

import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.services.todolist.create.CreateTodoListRequest;
import lv.javaguru.java2.console.services.todolist.create.CreateTodoListResponse;
import lv.javaguru.java2.console.services.todolist.create.CreateTodoListService;
import lv.javaguru.java2.console.services.users.getTodoList.GetTodoListRequest;
import lv.javaguru.java2.console.services.users.getTodoList.GetTodoListResponse;
import lv.javaguru.java2.console.services.users.getTodoList.GetTodoListService;
import lv.javaguru.java2.web.dtos.TodoListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class TodoListController {
    private static Logger logger = Logger.getLogger(HelloWorldController.class.getName());

    @Autowired
    private CreateTodoListService createTodoListService;

    @Autowired
    private GetTodoListService getTodoListService;

    @ResponseBody
    @PostMapping(value = "/user/{userId}/todoList")
    public ResponseEntity<TodoListDTO> createTodoList(@RequestBody TodoListDTO todoListDTO) {
        CreateTodoListRequest request = new CreateTodoListRequest(
                todoListDTO.getUserLogin(), todoListDTO.getTitle()
        );
        CreateTodoListResponse response = createTodoListService.create(request);
        todoListDTO.setId(response.getTodoListId());
        return ResponseEntity.ok(todoListDTO);
    }

    @RequestMapping(value = "/user/{userId}/todoList", method = RequestMethod.GET)
    public List<TodoList> getTodoList(@PathVariable("userId") Long userId) {
        GetTodoListRequest request = new GetTodoListRequest(userId);
        GetTodoListResponse response = getTodoListService.getTodoList(request);

//        logger.info("GetTodoListResponse" + response.getTodoList());
//
//        List<TodoList> list = new ArrayList<TodoList>();
//        for(TodoList dto:response.getTodoList()){
//            list.add(dto);
//        }
//
//        logger.info("GetTodoListResponse2" + list);

        return response.getTodoList();
    }

//    @RequestMapping(value = "/todoList/{login}/{title}", method = RequestMethod.GET)
//    public TodoListDTO getTodoList(@PathVariable("title") String title) {
//        GetTodoListRequest request = new GetTodoListRequest(userId);
//        GetTodoListResponse response = getTodoListService.get(request);
//        return new TodoListDTO(
//                response.getTodoList().getId(),
//                response.getTodoList().getLogin(),
//                response.getTodoList().getPassword()
//        );
//    }
}
