package lesson2.views;

import lesson2.services.AddTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddTodoView {

    @Autowired
    private AddTodoService addTodoService;

//    public AddTodoView(AddTodoService addTodoService) {
//        this.addTodoService = addTodoService;
//    }

    public void execute() {
        System.out.println();
        System.out.println("Add todo to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter todo title:");
        String title = sc.nextLine();
        System.out.print("Enter todo description:");
        String description = sc.nextLine();

        addTodoService.add(title, description);

        System.out.println("Add todo to list execution end!");
        System.out.println();
    }

}