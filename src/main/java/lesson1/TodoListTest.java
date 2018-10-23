package lesson1;

import java.util.Scanner;

class TodoListTest {

    public Integer counter = 0;

    public static void main(String[] args) {
        TodoList todos = new TodoList();

        showBigHeader();

        Scanner sc = new Scanner(System.in);
        int command = sc.nextInt();

        while (command != 4) {
            callee(command, todos);
            command = sc.nextInt();
        }
    }

    public static void callee(Integer command, TodoList todos) {
        Scanner sc = new Scanner(System.in);

        if (isAddSelected(command)) {
            System.out.println("Which ToDo do you want to [ADD], Master?");
            String todoText = sc.nextLine();
            ToDo todo1 = new ToDo(todoText, 1);
            todos.add(todo1);
            System.out.println("todo added: " + todoText);
        }

        if (isDeleteSelected(command)) {
            System.out.println("Which ToDo do you want to [DELETE], Master?");
            String todoText = sc.nextLine();
            ToDo todo1 = new ToDo(todoText, 1);
            todos.delete(todo1);
            System.out.println("todo deleted: " + todoText);
        }

        if (isPrintSelected(command)) {
            todos.print();
        }

        showSmallHeader();
    }

    private static boolean isAddSelected(Integer command) {
        return command == 1;
    }

    private static boolean isDeleteSelected(Integer command) {
        return command == 2;
    }

    private static boolean isPrintSelected(Integer command) {
        return command == 3;
    }

    public static void showSmallHeader() {
        System.out.println("1 = [ADD], 2 = [DELETE], 3 = [PRINT],  4 = [END]");
    }

    public static void showBigHeader() {
        System.out.println("Please enter: \n- 1 to [ADD],\n- 2 to [DELETE],\n- 3 to [PRINT] todoList items,\n- 4 to [END] programm: ");
    }

    public Integer getId() {
        return this.counter++;
    }
}
