package com.sofkau.count.controllers.auth.impl;


import com.sofkau.count.commons.auth.dtos.entry.AuthenticationRequest;
import com.sofkau.count.commons.auth.dtos.exit.AuthenticationResponse;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.controllers.auth.IAuthController;
import com.sofkau.count.services.auth.IAuthServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController implements IAuthController {

    @Autowired
    private IAuthServices iAuthServices;

    @Override
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthenticationResponse> register( @Valid @RequestBody UserEntryDTO userEntryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iAuthServices.register(userEntryDTO));
    }


    @Override
    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest authRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(iAuthServices.authenticate(authRequest));
    }

}
