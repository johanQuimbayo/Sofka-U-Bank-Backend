package com.sofkau.count.controllers.users;

import com.sofkau.count.commons.auth.dtos.exit.AuthenticationResponse;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersGetAllTest {

    @Autowired
    private TestRestTemplate testRest;

    private String jwt;



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
    public void testGetUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwt);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<UserExitDTO[]> response = testRest.exchange("/api/v1/users", HttpMethod.GET, httpEntity, UserExitDTO[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
    }
}
