package com.etiquette.Board.dtos;

import com.etiquette.User.dtos.AddUserDto;

public class AddBoardFormDto {
    
    private String name;
    private String description;
    private AddUserDto userOwner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddUserDto getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(AddUserDto userOwner) {
        this.userOwner = userOwner;
    }
}
