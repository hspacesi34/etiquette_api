package com.etiquette.Role;

import java.util.List;

import com.etiquette.Mapping.CustomMap;
import com.etiquette.User.User;
import com.etiquette.User.dtos.ReadUserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReadUserDto> getUsersByRole() {
        List<ReadUserDto> userReadDtoList = CustomMap.mapList(users, ReadUserDto.class);

        return userReadDtoList;
    }
    
}
