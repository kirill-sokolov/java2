package lesson2.views;

import lesson2.services.GetTodoListService;
import lesson2.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTodoListView {

//    @Autowired
    private GetTodoListService service;

    public PrintTodoListView(GetTodoListService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println();
        System.out.println("Print shopping list to console execution start!");

        for (Todo todo : service.getAllTodos()) {
            System.out.println(todo.getTitle() + "[" + todo.getDescription() + "]");
        }

        System.out.println("Print shopping list to console execution end!");
        System.out.println();
    }

}