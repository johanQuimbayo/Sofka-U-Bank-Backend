package com.sofkau.count.converters.users.impl;

import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.converters.users.IUserMapper;
import com.sofkau.count.domain.users.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IUserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User userEntryDTOtoUserCreate(UserEntryDTO userEntryDTO) {
        if (userEntryDTO == null) {
            throw new IllegalArgumentException("userEntryDTO can´t be empty");
        }
        User user = new User();
        user.setFirstName(userEntryDTO.getFirstName());
        user.setLastName(userEntryDTO.getLastName());
        user.setDocument(userEntryDTO.getDocument());
        user.setAddress(userEntryDTO.getAddress());
        user.setPhone(userEntryDTO.getPhone());
        user.setEmail(userEntryDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userEntryDTO.getPassword()));

        return user;
    }

    @Override
    public void userEntryDTOtoUserUpdate(User user, UserEntryDTO userEntryDTO) {
        if (userEntryDTO == null) {
            throw new IllegalArgumentException("userEntryDTO can´t be null");
        }
        user.setFirstName(userEntryDTO.getFirstName());
        user.setLastName(userEntryDTO.getLastName());
        user.setAddress(userEntryDTO.getAddress());
        user.setPhone(userEntryDTO.getPhone());
        user.setEmail(userEntryDTO.getEmail());
        user.setPassword(userEntryDTO.getPassword());
    }

    @Override
    public UserExitDTO usertoUserExit(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user can´t be empty");
        }
        return new UserExitDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDocument(),
                user.getAddress(),
                user.getPhone(),
                user.getEmail());
    }

}
