package com.sofkau.count.controllers.users;



import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface IUsersController {

    ResponseEntity<UserExitDTO> getUserById(Integer id);

    ResponseEntity<List<UserExitDTO>> getUsers();

    ResponseEntity<UserExitDTO> updateUser(UserEntryDTO userEntryDTO);

    ResponseEntity<Void> deleteUser(Integer id);

}
