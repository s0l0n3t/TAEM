package com.furkantokgoz.managementservice.domain.model;

public class Admin {
    //POJO entity class
    private String id;
    private final String username;
    private String password;

    public Admin(String username, String password) {
        if(username == null || username.trim().isEmpty()){
            throw new IllegalArgumentException("Username is null or empty"); //modify global exception
        }
        if(password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("Password is null or empty");
        }
        this.username = username;
        this.password = password;
    }
    //Overloading
    public Admin(String id,String username, String password) {
        if(username == null || username.trim().isEmpty()){
            throw new IllegalArgumentException("Username is null or empty"); //modify global exception
        }
        if(password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("Password is null or empty");
        }
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void changePassword(String newPassword) {
        if(newPassword == null || newPassword.trim().isEmpty()){
            throw new IllegalArgumentException("New Password is null or empty");
        }
        if(this.password.equals(newPassword)){
            throw new IllegalArgumentException("Passwords do not match");
        }
        this.password = newPassword;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getId() {
        return id;
    }
    //no setter feature
}
