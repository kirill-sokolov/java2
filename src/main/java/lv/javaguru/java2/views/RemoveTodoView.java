package lv.javaguru.java2.views;

import lv.javaguru.java2.services.remove.RemoveTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveTodoView {

    @Autowired
    private RemoveTodoService removeTodoService;

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