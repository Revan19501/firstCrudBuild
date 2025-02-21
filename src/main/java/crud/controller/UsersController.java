package crud.controller;

import crud.dao.UserDao;
import crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserDao userDao;

    @Autowired
    UsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return "show";
    }
}
