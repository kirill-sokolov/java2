package lv.javaguru.java2;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.views.AddTodoView;
import lv.javaguru.java2.views.PrintTodoListView;
import lv.javaguru.java2.views.RemoveTodoView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class TodoListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add todo to list
        // 2. Remove todo from list
        // 3. Print todo list to console
        // 4. Exit

        ApplicationContext context
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        AddTodoView addTodoView = context.getBean(AddTodoView.class);
        RemoveTodoView removeTodoView = context.getBean(RemoveTodoView.class);
        PrintTodoListView printTodoListView = context.getBean(PrintTodoListView.class);

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            }
            switch (menuItem) {
                case 1: {
                    addTodoView.execute();
                    break;
                }
                case 2: {
                    removeTodoView.execute();
                    break;
                }
                case 3: {
                    printTodoListView.execute();
                    break;
                }
            }
        }
    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add todo to list");
        System.out.println("2. Remove todo from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

}