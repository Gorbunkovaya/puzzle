package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService us;

    @Autowired
    public UsersController(UserService us) {
        this.us = us;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", us.getUsersList());
        return "users/allusers";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        us.createUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", us.getUserById(id));
        return "users/edit";
    }

    @PatchMapping(value = "{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        us.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteUserById(@PathVariable("id") Long id) {
        us.deleteUser(id);
        return "redirect:/users";
    }

}

