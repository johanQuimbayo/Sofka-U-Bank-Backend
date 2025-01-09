package com.sofkau.count.converters.users;


import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.domain.users.model.User;

public interface IUserMapper {

    public User mapUserEntryDTOtoUser(UserEntryDTO userEntryDTO);

    public UserExitDTO mapUsertoUserExit(User user);
}
