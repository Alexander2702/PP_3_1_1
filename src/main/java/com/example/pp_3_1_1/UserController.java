package com.example.pp_3_1_1;

import com.example.pp_3_1_1.model.User;
import com.example.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList",userList);
        return "user-list";
    }
    @GetMapping("/user-create")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "/user-update";
    }
    @PatchMapping("/user-update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/users";
    }
    @DeleteMapping("user-delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}