package com.foxmided.univerweb.Controller;

import com.foxmided.univerweb.Models.security.UserDetailsImpl;
import com.foxmided.univerweb.dto.LoginFormDto;
import com.foxmided.univerweb.Models.User;
import com.foxmided.univerweb.dto.RegistrationFormDto;
import com.foxmided.univerweb.Service.ModelService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String LoginForm() {
        return "login";
    }

    @PostMapping(value = "/login", consumes = {"application/x-www-form-urlencoded", "application/json"})
    public String loginPage(LoginFormDto loginFormDto, Model model, HttpServletRequest request) {
        User user = userService.findUserByEmailAndPassword(loginFormDto.getEmail(), loginFormDto.getPassword());
        if (user == null) {
            model.addAttribute("error", "Smth wrong");
            return "login";
        } else {
            UserDetailsImpl userDetails = UserDetailsImpl.build(user);
            String role = userDetails.getAuthorities().iterator().next().getAuthority();
            if (role.equals("ROLE_STUDENT") || role.equals("ROLE_TEACHER") || role.equals("ROLE_ADMIN")) {
                return "home";
            } else {
                return "error";
            }
        }
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping(value = "/register", consumes = {"application/x-www-form-urlencoded", "application/json"})
    public String registerPage(RegistrationFormDto registrationFormDto, Model model) {
        User cheackUser = userService.findUserByEmailAndPassword(registrationFormDto.getEmail(),registrationFormDto.getPassword());
        if(cheackUser != null){
            return "error";
        }
        else {
            User user = userService.addUser(registrationFormDto.getUsername(),
                registrationFormDto.getEmail(), registrationFormDto.getPassword(), "ROLE_STUDENT");
            return "login";
        }
    }
}
