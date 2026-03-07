package com.teefactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teefactory.demo.dto.LoginRequestDTO;
import com.teefactory.demo.dto.LoginResponseDTO;
import com.teefactory.demo.model.User;
import com.teefactory.demo.repositories.UserRepository;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> registrer(@RequestBody LoginRequestDTO loginRequest) {
        User user = new User();
        user.setLogin(loginRequest.login());
        user.setPassword(passwordEncoder.encode(loginRequest.password()));

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LoginResponseDTO(user.getLogin(), user.getPassword()));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("API funcionando!");
    }

}
