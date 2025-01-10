package com.sofkau.count.services.users;


import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;

import java.util.List;

public interface IUsersServices {


    UserExitDTO getUserById(Integer id);

    List<UserExitDTO> getUsers();

    UserExitDTO updateUser(UserEntryDTO userEntryDTO);

    void deleteUser(Integer id);

}
