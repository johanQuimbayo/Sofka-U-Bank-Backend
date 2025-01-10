package com.sofkau.count.controllers.users.impl;


import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.controllers.users.IUsersController;
import com.sofkau.count.services.users.IUsersServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController implements IUsersController {


    @Autowired
    private IUsersServices iUsersServices;


    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserExitDTO> getUserById(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok(iUsersServices.getUserById(id));
    }

    @Override
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserExitDTO>> getUsers() {
        return ResponseEntity.ok(iUsersServices.getUsers());
    }

    @Override
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserExitDTO> updateUser(@Valid @RequestBody  UserEntryDTO userEntryDTO) {
        return ResponseEntity.ok(iUsersServices.updateUser(userEntryDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteUser(@Valid @PathVariable Integer id) {
        iUsersServices.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
