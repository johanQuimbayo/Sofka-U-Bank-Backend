package com.sofkau.count.commons.users.dtos.entry;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntryDTO implements Serializable {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Integer document;


    private String address;

    @NotNull
    private String phone;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8)
    private String password;

}
