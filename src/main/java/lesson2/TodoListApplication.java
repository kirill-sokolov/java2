package lesson2;

import lesson2.db.TodoRepository;
import lesson2.db.jdbc.TodoRepositoryImpl;
import lesson2.services.AddTodoService;
import lesson2.services.GetTodoListService;
import lesson2.services.RemoveTodoService;
import lesson2.views.AddTodoView;
import lesson2.views.PrintTodoListView;
import lesson2.views.RemoveTodoView;

import java.util.Scanner;

public class TodoListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add todo to list
        // 2. Remove todo from list
        // 3. Print todo list to console
        // 4. Exit

        TodoRepository database = new TodoRepositoryImpl();

        AddTodoService addTodoService = new AddTodoService(database);
        RemoveTodoService removeTodoService = new RemoveTodoService(database);
        GetTodoListService getTodoListService = new GetTodoListService(database);

        AddTodoView addTodoView = new AddTodoView(addTodoService);
        RemoveTodoView removeTodoView = new RemoveTodoView(removeTodoService);
        PrintTodoListView printTodoListView = new PrintTodoListView(getTodoListService);

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