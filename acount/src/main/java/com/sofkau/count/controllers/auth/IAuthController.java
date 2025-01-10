package com.sofkau.count.controllers.auth;

import com.sofkau.count.commons.auth.dtos.exit.AuthenticationResponse;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;

import org.springframework.http.ResponseEntity;


public interface IAuthController {

    ResponseEntity<AuthenticationResponse> register(UserEntryDTO userEntryDTO);

    ResponseEntity<AuthenticationResponse> authenticate(UserEntryDTO userEntryDTO);
}
