package com.foxmided.univerweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SimpleController {
    @GetMapping("/home")
    public String homePage(Model model) {
        return "home";
    }

    @GetMapping
    public String welcomePage() {
        return "WelcomePage";
    }


}
