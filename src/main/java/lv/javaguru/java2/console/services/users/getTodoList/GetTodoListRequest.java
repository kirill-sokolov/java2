package lv.javaguru.java2.console.services.users.getTodoList;

public class GetTodoListRequest {
    private String userLogin;
    private Long userId;

    public GetTodoListRequest(Long userId) {
        this.userId = userId;
    }

    public GetTodoListRequest(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
