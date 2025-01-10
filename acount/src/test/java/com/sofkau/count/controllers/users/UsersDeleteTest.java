package com.sofkau.count.controllers.users;

import com.sofkau.count.commons.auth.dtos.exit.AuthenticationResponse;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersDeleteTest {

    @Autowired
    private TestRestTemplate testRest;

    private String jwt;

    private final Integer userId = 1;


    @BeforeEach
    public void setupAuthentication() {
        String userEntryDTO = "{\"firstName\": \"John\",\"lastName\": \"Doe\",\"document\": 12345678,\"address\": \"123 Main Street\",\"phone\": \"123-456-7890\",\"email\": \"john.doe@example.com\",\"password\": \"securePass1\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(userEntryDTO, headers);

        ResponseEntity<AuthenticationResponse> registerResponse = testRest.exchange("/api/v1/auth/register", HttpMethod.POST, httpEntity, AuthenticationResponse.class);
        assertEquals(HttpStatus.CREATED, registerResponse.getStatusCode());

        String authRequest = "{\"email\": \"john.doe@example.com\",\"password\": \"securePass1\"}";
        httpEntity = new HttpEntity<>(authRequest, headers);
        ResponseEntity<AuthenticationResponse> authResponse = testRest.exchange("/api/v1/auth/authenticate", HttpMethod.POST, httpEntity, AuthenticationResponse.class);
        assertEquals(HttpStatus.ACCEPTED, authResponse.getStatusCode());
        jwt = Objects.requireNonNull(authResponse.getBody()).getToken();
    }


    @Test
    public void testDeleteUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwt);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = testRest.exchange("/api/v1/users/" + userId, HttpMethod.DELETE, httpEntity, String.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
