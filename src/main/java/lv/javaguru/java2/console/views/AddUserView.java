package lv.javaguru.java2.console.views;


import lv.javaguru.java2.console.services.users.registration.UserRegistrationRequest;
import lv.javaguru.java2.console.services.users.registration.UserRegistrationResponse;
import lv.javaguru.java2.console.services.users.registration.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddUserView {

    @Autowired
    private UserRegistrationService userRegistrationService;

    public void execute() {
        System.out.println();
        System.out.println("Add user to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user login:");
        String title = sc.nextLine();
        System.out.print("Enter user password:");
        String description = sc.nextLine();

        UserRegistrationRequest request = new UserRegistrationRequest(title, description);
        UserRegistrationResponse response = userRegistrationService.register(request);

        if (response.isSuccess()){
            System.out.println("Add user to list execution end!" + response.getUserId());
        } else {
            System.out.println("Failed add user to list end!" + response.getErrors());
        }

        System.out.println();
    }

}