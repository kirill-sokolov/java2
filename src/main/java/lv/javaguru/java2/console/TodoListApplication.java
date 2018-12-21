package lv.javaguru.java2.console;

import lv.javaguru.java2.console.config.SpringAppConfig;
import lv.javaguru.java2.console.views.*;
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

        AddUserView addUserView = context.getBean(AddUserView.class);
        GetUserView getUserView = context.getBean(GetUserView.class);

        AddTodoListView addTodoListView = context.getBean(AddTodoListView.class);

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
                case 11: {
                    addUserView.execute();
                    break;
                }
                case 12: {
                    getUserView.execute();
                    break;
                }
                case 21: {
                    addTodoListView.execute();
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
        System.out.println("11. Add User");
        System.out.println("12. Get USer");
        System.out.println("21. Add Todo list");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

}