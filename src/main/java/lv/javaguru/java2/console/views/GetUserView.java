package lv.javaguru.java2.console.views;

import lv.javaguru.java2.console.services.users.get.GetUserRequest;
import lv.javaguru.java2.console.services.users.get.GetUserResponse;
import lv.javaguru.java2.console.services.users.get.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GetUserView {

    @Autowired
    private GetUserService getUserService;

    public void execute() {
        System.out.println();
        System.out.println("Add user to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user id:");
        Long userId = sc.nextLong();

        GetUserRequest request = new GetUserRequest(userId);
        GetUserResponse response = getUserService.get(request);

        if (response.isSuccess()){
            System.out.println("Get user execution end! " + response.getUser().getLogin());
        } else {
            System.out.println("Failed add user to list end!" + response.getError());
        }

        System.out.println();
    }

}