package com.sofkau.count.mappers.users.impl;

import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.mappers.users.IUserMapper;
import com.sofkau.count.data.users.model.User;

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
            throw new IllegalArgumentException("user can´t be empty");
        }
       return User.builder()
               .firstName(userEntryDTO.getFirstName())
               .lastName(userEntryDTO.getLastName())
               .document(userEntryDTO.getDocument())
               .address(userEntryDTO.getAddress())
               .phone(userEntryDTO.getPhone())
               .email(userEntryDTO.getEmail())
               .password(passwordEncoder.encode(userEntryDTO.getPassword())).build();
    }

    @Override
    public void userEntryDTOtoUserUpdate(User user, UserEntryDTO userEntryDTO) {
        if (userEntryDTO == null) {
            throw new IllegalArgumentException("user can´t be null");
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
        return UserExitDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .document(user.getDocument())
                .address(user.getAddress())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }

}
