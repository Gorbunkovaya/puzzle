package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
//@RequestMapping("/")
public class UsersController {

    private final UserService us;
    private final RoleService rs;

    @Autowired
    public UsersController(UserService us, RoleService rs) {
        this.us = us;
        this.rs = rs;
    }

    @GetMapping (value = "/user/{id}")
    public String userPage(Model model, @PathVariable ("id") Long id) {
        model.addAttribute("user", us.getUserById(id));
        return "user";
    }

    @GetMapping(value = "/admin/all")
    public String allUsers(Model model) {
        model.addAttribute("users", us.getUsersList());
        return "admin";
    }

    @GetMapping(value = "/admin/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", rs.getRolesList());
        return "new";
    }

    @PostMapping(value = "/admin/newuser")
    public String addUser(@ModelAttribute("user") User user, ModelMap model, @RequestParam(value = "rolesbox") String[] rolesBox) {
            Set<Role> roles = new HashSet<>();
            for (String rolesBoxes: rolesBox) {
                roles.add(rs.getRoleByName(rolesBoxes));
            }
            user.setRoles(roles);
            us.createUser(user);
            return "redirect:/admin/all";
        }


    @GetMapping(value = "/admin/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", us.getUserById(id));
        return "edit";
    }

    @PatchMapping(value = "/admin/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        us.updateUser(user);
        return "redirect:/admin/all";
    }

    @GetMapping(value = "/admin/{id}/delete")
    public String deleteUserById(@PathVariable("id") Long id) {
        us.deleteUser(id);
        return "redirect:/admin/all";
    }

}

