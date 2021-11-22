package com.tmjonker.food2u.controllers;

import com.tmjonker.food2u.entities.user.NewUserForm;
import com.tmjonker.food2u.entities.user.ReturningUserForm;
import com.tmjonker.food2u.entities.user.User;
import com.tmjonker.food2u.entities.user.UserRepository;
import com.tmjonker.food2u.logging.Food2uLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class SignUpController {

    private static final Logger LOGGER = Food2uLogger.setUp(SignUpController.class.getName());

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/sign-up")
    public String signUpForm(@ModelAttribute NewUserForm newUserForm, Model model) {
        model.addAttribute("newUserForm", newUserForm);
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpSubmit(@ModelAttribute @Valid NewUserForm newUserForm, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes) {

        /* validates input by checking to see if password1 matches password2. Also checks if the email entered is already
        associated with an existing user, and if all fields are adequately filled in.
         */
        if (!newUserForm.getPassword().equals(newUserForm.getPassword2())) {
            newUserForm.setPasswordsMatch(false);
            return "sign-up";
        } else if (bindingResult.hasErrors()){
            return "sign-up";
        } else {
            User newUser = newUserForm.toUser();
            if (!userRepository.existsByEmail(newUser.getEmail())) {
                newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
                userRepository.save(newUser);
                model.addAttribute("user", newUser);
                return "welcome";
            } else {
                ReturningUserForm returningUserForm = new ReturningUserForm(newUser.getEmail(), true);
                redirectAttributes.addFlashAttribute("returningUserForm", returningUserForm);
                return "redirect:/sign-in";
            }
        }
    }
}