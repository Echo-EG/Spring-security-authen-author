package com.riawolf.Todospringspeedrun8.modal.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;
    private String password;
    private String role;
    private Integer id;
    private Boolean enabled;

}
