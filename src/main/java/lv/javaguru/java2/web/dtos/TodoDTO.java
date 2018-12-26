package lv.javaguru.java2.web.dtos;

public class TodoDTO {
    private Long id;
    private String description;
    private String title;
    private Long todoListId;

    public TodoDTO() {}

    public TodoDTO(Long id, String title, String description, Long todoListId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.todoListId = todoListId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(Long todoListId) {
        this.todoListId = todoListId;
    }
}
