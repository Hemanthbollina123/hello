package com.mycompany.myloginapp.controller;

import com.mycompany.myloginapp.model.User;
import com.mycompany.myloginapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        if (authService.authenticate(user)) {
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
