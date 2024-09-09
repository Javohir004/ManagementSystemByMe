package uz.jvh.prjoectmanagement.controller;

import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.jvh.prjoectmanagement.domain.dto.request.LoginDto;
import uz.jvh.prjoectmanagement.domain.dto.request.UserCreateDto;
import uz.jvh.prjoectmanagement.domain.dto.response.JwtResponse;
import uz.jvh.prjoectmanagement.service.AuthService;
import uz.jvh.prjoectmanagement.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserCreateDto user) throws AuthException {
     userService.save(user);
     return "saved";
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginDto loginDto) throws AuthException {
        return authService.login(loginDto);
    }
}
