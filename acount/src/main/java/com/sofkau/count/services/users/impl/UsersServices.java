package com.sofkau.count.services.users.impl;


import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.exceptions.NotFoundException;
import com.sofkau.count.mappers.users.IUserMapper;
import com.sofkau.count.data.users.model.User;
import com.sofkau.count.data.users.repository.UsersRepository;
import com.sofkau.count.services.users.IUsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServices implements IUsersServices {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    IUserMapper iUserMapper;


    @Override
    public UserExitDTO getUserById(Integer id) {
        User user = usersRepository.findById(id).orElseThrow(() -> new NotFoundException("User not Found"));
        return iUserMapper.usertoUserExit(user);
    }

    @Override
    public List<UserExitDTO> getUsers() {
       List<User> users = usersRepository.findAllByOrderByIdAsc();
       return users.stream()
               .map(iUserMapper::usertoUserExit)
               .collect(Collectors.toList());
    }

    @Override
    public UserExitDTO updateUser(UserEntryDTO userEntryDTO) {

        User user = usersRepository.findByDocument(
                userEntryDTO.getDocument()).orElseThrow(() -> new NotFoundException("User not Found"));

        iUserMapper.userEntryDTOtoUserUpdate(user, userEntryDTO);

        usersRepository.save(user);
        return iUserMapper.usertoUserExit(user);

    }

    @Override
    public void deleteUser(Integer id) {
        User user = usersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Can´t delete user if this doesn´t exist")
        );
        usersRepository.delete(user);

    }
}
