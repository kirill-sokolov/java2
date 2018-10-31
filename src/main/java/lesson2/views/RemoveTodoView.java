package lesson2.views;

import lesson2.services.RemoveTodoService;

import java.util.Scanner;

public class RemoveTodoView {

    private RemoveTodoService removeTodoService;

    public RemoveTodoView(RemoveTodoService removeTodoService) {
        this.removeTodoService = removeTodoService;
    }

    public void execute() {
        System.out.println();
        System.out.println("Remove todo from list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter todo title:");
        final String title = sc.nextLine();

        boolean isRemoved = removeTodoService.remove(title);

        if (isRemoved) {
            System.out.println("Todo with title " + title + " was found and will be removed from list!");
        } else {
            System.out.println("Todo with title " + title + " not found and not be removed from list!");
        }

        System.out.println("Remove todo from list execution end!");
        System.out.println();
    }

}