package com.game.clicker.controllers;


import com.game.clicker.messages.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.game.clicker.entity.User;
import com.game.clicker.services.UserService;

import java.net.URI;
import java.util.Objects;

@RestController
public class UserController {
    User currentUser;
    @Autowired
    private UserService userService;

    @GetMapping("/api/users/get")
    public Page<User> getUsers(@RequestParam Integer page, @RequestParam Integer size) {
        return userService.getUsers(PageRequest.of(page, size));
    }

    @PostMapping("api/users/register")
    public ResponseEntity<Object> register(@RequestParam String username,
                                           @RequestParam String password) {
        currentUser = new User(username, password);
        String code = userService.addUser(currentUser);

        if (Objects.equals(code, Messages.SUCCESSFUL_LOGIN) || Objects.equals(code, Messages.SUCCESSFULLY_REGISTERED)) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/game")).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080")).build();
    }
    @PostMapping("api/users/updateCounter")
    public ResponseEntity<Object> updateCounter(){
        userService.incrementScore(currentUser);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/game")).build();

    }
}

















