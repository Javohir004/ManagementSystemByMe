package uz.jvh.prjoectmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.jvh.prjoectmanagement.domain.dto.request.LoginDto;
import uz.jvh.prjoectmanagement.domain.dto.response.JwtResponse;
import uz.jvh.prjoectmanagement.entity.UserEntity;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    public JwtResponse login(LoginDto loginDto) {
        UserEntity user = userService.findByUsername(loginDto.getUsername());
        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return new JwtResponse(jwtService.generateToken(user));

        }
        throw new UsernameNotFoundException("Invalid username or password");
    }


}
