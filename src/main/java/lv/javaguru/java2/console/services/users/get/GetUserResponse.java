package lv.javaguru.java2.console.services.users.get;

import lv.javaguru.java2.console.services.Error;
import lv.javaguru.java2.console.domain.User;

public class GetUserResponse {
    private User user;

    private Error error;

    public GetUserResponse(User user) {
        this.user = user;
    }

    public GetUserResponse(Error error) {
        this.error = error;
    }

    public User getUser() {
        return user;
    }

    public Error getError() {
        return error;
    }

    public boolean isSuccess() {
        return user != null && (error == null) ;
    }
}
