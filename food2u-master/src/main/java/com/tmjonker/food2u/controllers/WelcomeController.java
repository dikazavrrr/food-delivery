package com.tmjonker.food2u.controllers;

import com.tmjonker.food2u.entities.user.User;
import com.tmjonker.food2u.entities.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class WelcomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/welcome")
    public String displayResult(HttpServletRequest request, Model model) {

        Principal principal = request.getUserPrincipal();
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);

        return "welcome";
    }
    @GetMapping("/users")
    public String getAllUsers(Model model) {


        model.addAttribute("userList",userRepository.findAll());

        return "users";
    }
}
