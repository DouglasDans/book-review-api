package dev.dans.bookreview.infra.adapters.controllers;

import dev.dans.bookreview.application.service.AuthService;
import dev.dans.bookreview.infra.adapters.dtos.LoginDTO;
import dev.dans.bookreview.infra.adapters.dtos.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public SessionDTO login(@RequestBody LoginDTO login) {
        return authService.login(login);
    }
}
