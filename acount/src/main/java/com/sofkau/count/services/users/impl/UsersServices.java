package com.sofkau.count.services.users.impl;



import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.commons.users.exceptions.AlreadyExistsException;
import com.sofkau.count.commons.users.exceptions.NotFoundException;
import com.sofkau.count.converters.users.IUserMapper;
import com.sofkau.count.domain.users.model.User;
import com.sofkau.count.domain.users.repository.UsersRepository;
import com.sofkau.count.services.users.IUsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices implements IUsersServices {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    IUserMapper iUserMapper;


    @Override
    public void createUser(UserEntryDTO userDTO) {
        try {
            usersRepository.findByDocument(userDTO.getDocument()).ifPresent(
                    u -> { throw new AlreadyExistsException("already exist an user with the same email");});

            User user = iUserMapper.mapUserEntryDTOtoUser(userDTO);
            usersRepository.save(user);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserExitDTO updateUser(UserEntryDTO userEntryDTO) {
        try {
            User user = usersRepository.findByDocument(
                    userEntryDTO.getDocument()).orElseThrow(() -> new NotFoundException("User not Found"));

            iUserMapper.mapUserEntryDTOtoUser(userEntryDTO);
            usersRepository.save(user);
            UserExitDTO UserExitDTO = iUserMapper.mapUsertoUserExit(user);
            return UserExitDTO;

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(Integer id) {
        usersRepository.findById(id).orElseThrow(() -> new NotFoundException("Can´t delete user if this doesn´t exist"));
        deleteUser(id);

    }
}
