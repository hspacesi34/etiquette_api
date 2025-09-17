package com.etiquette.User.dtos;

import com.etiquette.Role.dtos.AddRoleFormDto;

public class AddUserFormDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private AddRoleFormDto role;

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddRoleFormDto getRole() {
        return role;
    }

    public void setRole(AddRoleFormDto addRoleFormDto) {
        this.role = addRoleFormDto;
    }
}