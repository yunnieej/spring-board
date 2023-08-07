package project.springboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.springboard.dto.UserDto;
import project.springboard.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String main(Model model){
        return "/index.html";
    }

    @GetMapping("/join")
    public String joinForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "user/join.html";
    }

    @PostMapping("/join")
    public String join(@Valid UserDto userDto, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            return "user/join.html";
        }
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

    // 비밀번호 5번 틀릴시 잠김?.. 잠기면 풀어야함.. id있는 사람에 한해서.. db 저장되어야함 count.
    @GetMapping("/login")
    public String loginForm(HttpSession session){
//        session.setAttribute("userind","sdfsd");
//        String userid= session.getAttribute("sdf");
        return "user/login.html";
    }

    @PostMapping("/login")
    public String login(UserDto userDto, HttpServletRequest request, RedirectAttributes attr){

        return "redirect:/";
    }

}
