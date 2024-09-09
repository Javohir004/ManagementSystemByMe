package uz.jvh.prjoectmanagement.service;

import jakarta.security.auth.message.AuthException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.jvh.prjoectmanagement.domain.dto.request.UserCreateDto;
import uz.jvh.prjoectmanagement.entity.UserEntity;
import uz.jvh.prjoectmanagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException
                        ("Username " + username + " not found"));
    }

    public UserEntity save(UserCreateDto userCreateDto) throws AuthException {
        UserEntity map = modelMapper.map(userCreateDto, UserEntity.class);
        map.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        return userRepository.save(map);

    }
}
