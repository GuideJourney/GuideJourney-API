package com.guidejourney.services;

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

    public void registerUser(LoginDTO loginDTO) {
        User user = new User();
        user.setEmail(loginDTO.getEmail());
        user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        // Aquí puedes configurar cualquier otro valor predeterminado, como el rol básico de usuario
        userRepository.save(user);
    }
}
