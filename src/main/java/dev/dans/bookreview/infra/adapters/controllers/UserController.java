package dev.dans.bookreview.infra.adapters.controllers;

import dev.dans.bookreview.application.service.UserService;
import dev.dans.bookreview.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id) throws Exception {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
