package com.sofkau.count.services.auth;

import com.sofkau.count.commons.auth.dtos.entry.AuthenticationRequest;
import com.sofkau.count.commons.auth.dtos.exit.AuthenticationResponse;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;

public interface IAuthServices {

    AuthenticationResponse register(UserEntryDTO userDTO);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
