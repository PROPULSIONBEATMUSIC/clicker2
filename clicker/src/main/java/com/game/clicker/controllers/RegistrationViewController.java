package com.game.clicker.controllers;

import com.github.mustachejava.MustacheParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistrationViewController {
    @GetMapping
    public String getRegistrationPage() {
        return "registration";
    }

    @GetMapping("/game")
    public String getMainGame() {
        return "game";
    }
}
