package project.springboard.controller;

import org.springframework.stereotype.Controller;
import project.springboard.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

}
