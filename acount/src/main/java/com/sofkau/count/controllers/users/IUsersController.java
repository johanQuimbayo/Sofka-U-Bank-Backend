package com.sofkau.count.controllers.users;



import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import org.springframework.http.ResponseEntity;

public interface IUsersController {

    public ResponseEntity<Void> createUser(UserEntryDTO userDTO);

    public ResponseEntity<UserExitDTO> updateUser(UserEntryDTO userEntryDTO);

    public ResponseEntity<Void> deleteUser(Integer id);

}
