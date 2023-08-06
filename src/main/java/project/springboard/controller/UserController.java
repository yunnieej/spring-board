package project.springboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.springboard.dto.UserDto;
import project.springboard.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String main(){
        return "/index.html";
    }
    @GetMapping("/join")
    public String joinForm(){
        return "user/join.html";
    }

    @PostMapping("/join")
    public String join(UserDto userDto, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return "user/join.html";
//        }
        userService.save(userDto);
        System.out.println(userDto);
        return "redirect:/";
    }

    @GetMapping("/id-check")
    public ResponseEntity<Boolean> checkId(@RequestParam("userId") String userId){
        System.out.println("print : " + userId);
        //중복일 경우 true, 아닐경우 false
        return ResponseEntity.ok(userService.existsByUserId(userId));
    }

    @GetMapping("/login")
    public String loginForm(){
        return "user/login.html";
    }

}
