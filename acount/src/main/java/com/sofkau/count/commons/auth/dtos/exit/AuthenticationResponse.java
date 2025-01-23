package com.sofkau.count.commons.auth.dtos.exit;

import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private UserExitDTO userExitDTO;

    private String token;
}
