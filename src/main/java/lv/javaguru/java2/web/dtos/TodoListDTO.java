package lv.javaguru.java2.web.dtos;

public class TodoListDTO {
    private Long id;
    private Long userId;
    private String userLogin;
    private String title;

    public TodoListDTO() {
    }

    public TodoListDTO(Long id, Long userId, String userLogin, String title) {
        this.id = id;
        this.userId = userId;
        this.userLogin = userLogin;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String title) {
        this.userLogin = userLogin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
