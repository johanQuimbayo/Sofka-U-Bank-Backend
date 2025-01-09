package com.sofkau.count.services.users;


import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;

public interface IUsersServices {


    public void createUser(UserEntryDTO userDTO);

    public UserExitDTO updateUser(UserEntryDTO userEntryDTO);

    public void deleteUser(Integer id);

}
