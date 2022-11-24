package com.houser.devtrac_Using_Intellij.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "This is Spring Boot!";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/")
    public String home() {
        return "index";
    }

}
