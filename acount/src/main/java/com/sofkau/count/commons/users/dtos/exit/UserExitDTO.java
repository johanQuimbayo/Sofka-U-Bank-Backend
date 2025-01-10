package com.sofkau.count.commons.users.dtos.exit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserExitDTO implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer document;
    private String address;
    private String phone;
    private String email;

}
