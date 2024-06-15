package com.guidejourney.mapper;

import com.guidejourney.model.dto.LoginDTO;
import com.guidejourney.model.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User loginDTOToUser(LoginDTO loginDTO) {
        return modelMapper.map(loginDTO, User.class);
    }
}
