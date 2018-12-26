package lv.javaguru.java2.console.services.todolist.create;

public class CreateTodoListRequest {
    private String userLogin;
    private String title;

    public CreateTodoListRequest(String userLogin, String title) {
        this.userLogin = userLogin;
        this.title = title;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserId(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
