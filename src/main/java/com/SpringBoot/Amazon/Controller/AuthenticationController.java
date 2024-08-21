package com.SpringBoot.Amazon.Controller;

import com.SpringBoot.Amazon.Model.Login;
import com.SpringBoot.Amazon.Model.User;
import com.SpringBoot.Amazon.Service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<String> register (@Valid @RequestBody User user) {
        return ResponseEntity.ok().body(service.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login ( @Valid @RequestBody Login login) {
        return service.login(login);
    }

}

