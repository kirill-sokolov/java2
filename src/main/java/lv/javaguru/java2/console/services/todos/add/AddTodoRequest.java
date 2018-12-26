package lv.javaguru.java2.console.services.todos.add;

public class AddTodoRequest {
    private String title;
    private String description;
    private Long todoListId;

    public AddTodoRequest(String title, String description, Long todoListId) {
        this.title = title;
        this.description = description;
        this.todoListId = todoListId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(Long todoListId) {
        this.todoListId = todoListId;
    }
}