package lv.javaguru.java2.console.views;

import lv.javaguru.java2.console.services.todos.add.AddTodoRequest;
import lv.javaguru.java2.console.services.todos.add.AddTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddTodoView {

    @Autowired
    private AddTodoService addTodoService;

    public void execute() {
        System.out.println();
        System.out.println("Add todo to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter todo title:");
        String title = sc.nextLine();
        System.out.print("Enter todo description:");
        String description = sc.nextLine();
        System.out.print("Enter todo todoListId:");
        Long todoListId = sc.nextLong();

//        addTodoService.add(title, description);
        AddTodoRequest request = new AddTodoRequest(title, description, todoListId);
        addTodoService.add(request);

        System.out.println("Add todo to list execution end!");
        System.out.println();
    }

}