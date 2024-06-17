package com.guidejourney.services;

import com.guidejourney.exceptions.UserAlreadyExistsException;
import com.guidejourney.mapper.UserMapper;
import com.guidejourney.model.dto.LoginDTO;
import com.guidejourney.model.entities.User;
import com.guidejourney.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public User registerUser(LoginDTO loginDTO) throws UserAlreadyExistsException {
        if (userRepository.existsByEmail(loginDTO.getEmail())) {
            throw new UserAlreadyExistsException("User with email " + loginDTO.getEmail() + " already exists.");
        }
        User user = userMapper.loginDTOToUser(loginDTO);
        user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        return userRepository.save(user);
    }
}
