package com.nashb.todo.controllers;

import com.nashb.todo.users.User;
import com.nashb.todo.users.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) throws Exception {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.findByEmailAndPassword(email, password);
        System.out.println(user.getUserId());
        if (!user.getEmail().isEmpty()) {
            Map<String, String> map = new HashMap<>();
            map.put("message", "LogedIn Successfully");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search-by-email")
    public User searchByEmail(@RequestBody String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/first-name")
    public List<User> getAllUsersByFirstName(@RequestBody String firstName) {
        return userService.findAllUsersByFirstName(firstName);
    }

}
