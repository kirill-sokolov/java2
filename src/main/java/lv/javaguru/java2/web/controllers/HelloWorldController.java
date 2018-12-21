package lv.javaguru.java2.web.controllers;

import lv.javaguru.java2.console.services.todos.add.AddTodoRequest;
import lv.javaguru.java2.console.services.todos.add.AddTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class HelloWorldController {

    private static Logger logger = Logger.getLogger(HelloWorldController.class.getName());

    @Autowired
    private AddTodoService addTodoService;

    @RequestMapping(value = "hello/{id}", method = {RequestMethod.GET})
    public ModelAndView processGet(HttpServletRequest request,
                                   @PathVariable Long id) {

        logger.info("ID = " + id);

        String todoTitle = request.getParameter("title");
        String todoDescription = request.getParameter("description");

//        addTodoService.add(todoTitle, todoDescription);
        AddTodoRequest addTodoRequest = new AddTodoRequest(todoTitle, todoDescription);
        addTodoService.add(addTodoRequest);

        return new ModelAndView("helloWorld", "model", "Hello from MVC!");
    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET})
    public ModelAndView process(HttpServletRequest request) {

        String todoTitle = request.getParameter("title");
        String todoDescription = request.getParameter("description");

//        addTodoService.add(todoTitle, todoDescription);
        AddTodoRequest addTodoRequest = new AddTodoRequest(todoTitle, todoDescription);
        addTodoService.add(addTodoRequest);

        return new ModelAndView("helloWorld", "model", "Hello from MVC!");
    }
}
