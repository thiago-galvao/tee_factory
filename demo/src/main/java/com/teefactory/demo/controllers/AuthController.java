package com.teefactory.demo.controllers;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teefactory.demo.config.TokenConfig;
import com.teefactory.demo.dto.LoginRequestDTO;
import com.teefactory.demo.dto.LoginResponseDTO;
import com.teefactory.demo.dto.RegisterRequestDTO;
import com.teefactory.demo.dto.RegisterResponseDTO;
import com.teefactory.demo.model.User;
import com.teefactory.demo.repositories.UserRepository;
import com.teefactory.demo.roles.UserRole;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenConfig tokenConfig;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO register) {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(register.login(),
                register.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @GetMapping("/register")
    public ModelAndView registerGet() {
        ModelAndView mv = new ModelAndView("register-user");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute RegisterRequestDTO registerRequest, RedirectAttributes ra) {
        User user = new User();
        ModelAndView mv = new ModelAndView("register-user");
        UserRole role = UserRole.USER; 
        user.setLogin(registerRequest.login());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        user.setRole(role);
        
        userRepository.save(user);
        mv.addObject("successMessage", "Registrado com Sucesso");
        return mv;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("API funcionando!");
    }

}
