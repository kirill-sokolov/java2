package lv.javaguru.java2.console.services.users.get;

public class GetUserRequest {
    private Long userId;

    public GetUserRequest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
}
