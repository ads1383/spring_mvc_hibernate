package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;



@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "index";
    }

    @GetMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("message", "Add new User");
        model.addAttribute("user", user);
        return "adduser";
    }

    @PostMapping(value = "/saveuser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @PostMapping(value = "/updateuser")
    public String updateUser(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("message", "Update User");
        model.addAttribute("user", userService.getById(id));
        return "adduser";
    }

    @PostMapping(value = "/deleteuser")
    public String removeUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
