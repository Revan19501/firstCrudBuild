package crud.controller;

import crud.entity.User;
import crud.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String start() {
        return "index";
    }

    @GetMapping("/allusers")
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "show";
    }

    @GetMapping("/adduser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "adduser";
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println("Received user: " + user.getFirstName() + " " + user.getLastName());
        userService.addUser(user);
        return "redirect:/users/allusers";
    }

    @GetMapping("/updateuser")
    public String updateUser(@RequestParam("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "adduser";
    }
    @GetMapping("/deleteuser")
    public String deleteUser(@RequestParam("id") int id, Model model) {
        userService.deleteUserById(id);
        return "redirect:/users/allusers";
    }

    @GetMapping("/createtable")
    public String createTable(Model model) {
        userService.createTable();
        return "redirect:/users/allusers";
    }
}
