package com.etiquette.User.dtos;

public class UpdateUserDto extends AddUserFormDto {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    
}
