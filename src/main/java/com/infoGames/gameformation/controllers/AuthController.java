package com.infoGames.gameformation.controllers;

import com.infoGames.gameformation.models.User;
import com.infoGames.gameformation.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userDao, PasswordEncoder passwordEncoder){
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(path = "/login")
    public String loginForm(){
        return "/users/login";
    }

    @GetMapping(path = "/signup")
    public String signupPage(Model model){
        model.addAttribute("user", new User());
        return "/users/signup";
    }

    @PostMapping(path = "/signup")
    public String signup(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile";
    }

    @GetMapping(path = "/profile")
    public String profilePage(){
        return "/users/profile";
    }
}
