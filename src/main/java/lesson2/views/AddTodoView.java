package lesson2.views;

import lesson2.services.AddTodoService;

import java.util.Scanner;

public class AddTodoView {

    private AddTodoService addTodoService;

    public AddTodoView(AddTodoService addTodoService) {
        this.addTodoService = addTodoService;
    }

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