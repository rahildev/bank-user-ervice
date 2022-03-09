package az.kapitalbank.birbankuser.controller;

import az.kapitalbank.birbankuser.domain.User;
import az.kapitalbank.birbankuser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
//        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUser(id));
//        return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> creatUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> changeUser(@PathVariable Long id, @RequestBody User user){
    return ResponseEntity.ok(userService.changeUser(id,user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
