package com.furkantokgoz.managementservice.application.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class AdminCommand {
    private final String id;
    private final String username;
    private final String password;

    public AdminCommand(String username, String password, String id) {
        if(username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if(password == null || password.trim().isEmpty() || password.length() < 5) {
            throw new IllegalArgumentException("Password cannot be null or password length less than 5");
        }
        this.username = username;
        this.password = password;
        this.id = id;
    }
}
