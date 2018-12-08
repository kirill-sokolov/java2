package lv.javaguru.java2.console.views;

import lv.javaguru.java2.console.businesslogic.gettodolist.GetTodoListService;
import lv.javaguru.java2.console.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTodoListView {

    @Autowired
    private GetTodoListService service;


    public void execute() {
        System.out.println();
        System.out.println("Print todo list to console execution start!");

        for (Todo todo : service.getAllTodos()) {
            System.out.println(todo.getTitle() + "[" + todo.getDescription() + "]");
        }

        System.out.println("Print todo list to console execution end!");
        System.out.println();
    }

}