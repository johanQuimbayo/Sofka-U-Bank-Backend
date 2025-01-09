package com.sofkau.count.commons.users.dtos.entry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {

    @NotNull
    @Email
    public String email;

    @NotNull
    @Size(min = 8, message = "The password must be at least 8 characters long")
    public String password;


}
