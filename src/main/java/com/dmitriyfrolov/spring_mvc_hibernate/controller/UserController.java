package com.dmitriyfrolov.spring_mvc_hibernate.controller;

import com.dmitriyfrolov.spring_mvc_hibernate.entity.User;
import com.dmitriyfrolov.spring_mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class MyController {

    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    GetMapping()
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @RequestMapping("/new")
    public String addNewUser(Model model) {

        model.addAttribute("user", new User());

        return "user-info";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
