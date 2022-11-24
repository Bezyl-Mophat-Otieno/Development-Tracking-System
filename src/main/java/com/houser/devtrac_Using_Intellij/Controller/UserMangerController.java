package com.houser.devtrac_Using_Intellij.Controller;

import com.houser.devtrac_Using_Intellij.Entities.User;
import com.houser.devtrac_Using_Intellij.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/umgr")
@Controller
public class UserMangerController {
    private UserService userService;
@Autowired
    public UserMangerController(UserService userService) {
        super();
        this.userService = userService;
    }

    // display list of users
    @GetMapping("/list")
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "userList";
    }
    @GetMapping("/adduser")
    public String showAddUser(Model model) {
        User user = new User();
// create model attribute to bind form data
        model.addAttribute("user", user);
        return "newUser";
    }
    @GetMapping("/UserUpdate/{id}")
    public String UserUpdate(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id); // get a user from the service
        model.addAttribute("user", user);
        return "updateUser";
    }


    // set user as a model attribute to
    @PostMapping("/saveUser")
    public String saveUserDetails(@ModelAttribute("user") User user) {
        userService.saveUser(user);
// save user details to database
        return "redirect:/umgr/list";
    }
    @PostMapping("/saveUserdets")
    public String saveUserPrivileges(@ModelAttribute("user") User user) {
//userService.saveUser(user);
// save user details to database
        return "redirect:/umgr/list";
    }
    @GetMapping("/deleteUser/{id}")
    public String removeUser(@PathVariable(value = "id") long id) {
        this.userService.deleteUserById(id);
// call delete user method
        return "redirect:/umgr/list";
    }
    @ModelAttribute("user")
    public User userRegistrationDto() {
        return new User();
    }
    @GetMapping
    public String showRegistrationForm() {
        return "registration";

    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}

