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
    public String main(@SessionAttribute(name="userId", required = false) String userId){
        if(userId == null){
            System.out.println("로그인 안함");
        }
        else{
            System.out.println("로그인 유저 id : " + userId);
        }

        return "/index.html";
    }

    @GetMapping("/join")
    public String joinForm(){
//        model.addAttribute("userDto", new UserDto());
        return "user/join.html";
    }

    @PostMapping("/join")
    public String join(UserDto userDto, Model model){

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
    public String loginForm(){
        return "user/login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("userPassword") String userPassword,
                        UserDto userDto, HttpServletRequest httpServletRequest){

        System.out.println("로그인한 id: " + userId);
        System.out.println("로그인한 pw: " + userPassword);

        if(userService.login(userId, userPassword) == true) {
            // 세션이 있으면 세션값 return, 없으면 생성한 후 return
            HttpSession session = httpServletRequest.getSession(true);
            System.out.println("세션값은" + session);
            // session이 생성되었으니까 이 session의 key, value 값을 넣어준다.
            session.setAttribute("userId", userDto.getUserId());
            session.setMaxInactiveInterval(1800); //1800초 = 30분
            return "redirect:/";
        }
        else{
            return "user/login.html";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        System.out.println("session은?" + session);

        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/post")
    public String postForm(@SessionAttribute(name="userId", required = false) String userId, Model model){

        if(userId == null){
            return "redirect:/";
        }
        else{
            System.out.println("로그인 유저 id : " + userId);
            return "user/post.html";
        }
    }
}
