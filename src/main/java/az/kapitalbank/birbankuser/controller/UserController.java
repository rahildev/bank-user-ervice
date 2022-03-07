package az.kapitalbank.birbankuser.controller;

import az.kapitalbank.birbankuser.domain.User;
import az.kapitalbank.birbankuser.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Long id) {

        return userService.findUser(id);
    }

    @PostMapping("/users")
    public User creatUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
