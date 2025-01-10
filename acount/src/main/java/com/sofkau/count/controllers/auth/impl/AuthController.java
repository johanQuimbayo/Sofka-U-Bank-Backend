package com.sofkau.count.controllers.auth.impl;


import com.sofkau.count.commons.auth.dtos.exit.AuthenticationResponse;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.controllers.auth.IAuthController;
import com.sofkau.count.services.auth.IAuthServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController implements IAuthController {

    @Autowired
    private IAuthServices iAuthServices;

    @Override
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register( @Valid @RequestBody UserEntryDTO userEntryDTO) {
        return ResponseEntity.ok(iAuthServices.register(userEntryDTO));
    }


    @Override
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody UserEntryDTO userEntryDTO) {
        return ResponseEntity.ok(iAuthServices.authenticate(userEntryDTO));
    }

}
