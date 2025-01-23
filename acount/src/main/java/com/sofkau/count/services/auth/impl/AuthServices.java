package com.sofkau.count.services.auth.impl;



import com.sofkau.count.commons.auth.dtos.entry.AuthenticationRequest;
import com.sofkau.count.commons.auth.dtos.exit.AuthenticationResponse;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.config.JwtService;
import com.sofkau.count.exceptions.NotFoundException;
import com.sofkau.count.mappers.users.IUserMapper;
import com.sofkau.count.data.users.repository.UsersRepository;
import com.sofkau.count.exceptions.AlreadyExistsException;
import com.sofkau.count.services.auth.IAuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.sofkau.count.data.users.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthServices implements IAuthServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    IUserMapper iUserMapper;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(UserEntryDTO userDTO) {
        usersRepository.findByDocument(userDTO.getDocument()).ifPresent(
                u -> {
                    throw new AlreadyExistsException("already exist an user with the same email");
                });

        User user = iUserMapper.userEntryDTOtoUserCreate(userDTO);

        usersRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userExitDTO(iUserMapper.usertoUserExit(user))
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                authenticationRequest.getPassword()));

        User user = usersRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(() -> new NotFoundException("User not found"));

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userExitDTO(iUserMapper.usertoUserExit(user))
                .token(jwtToken)
                .build();
    }
}
