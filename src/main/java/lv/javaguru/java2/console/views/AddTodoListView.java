package lv.javaguru.java2.console.views;

import lv.javaguru.java2.console.services.todolist.create.CreateTodoListRequest;
import lv.javaguru.java2.console.services.todolist.create.CreateTodoListResponse;
import lv.javaguru.java2.console.services.todolist.create.CreateTodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddTodoListView {

    @Autowired
    private CreateTodoListService createTodoListService;

    public void execute() {
        System.out.println();
        System.out.println("Add todo list to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user login:");
        String login = sc.nextLine();
        System.out.print("Enter todo list title:");
        String title = sc.nextLine();
//        System.out.print("Enter user password:");
//        String description = sc.nextLine();

//        addTodoService.add(title, description);
        CreateTodoListRequest request = new CreateTodoListRequest(login, title);
//        CreateTodoListRequest request = new CreateTodoListRequest("login", "password");
        CreateTodoListResponse response = createTodoListService.create(request);
//        CreateTodoListService.register(request);



        System.out.println("Add todo list to list execution end!");
        System.out.println();
    }

}