package com.scaler.productservice.models;

import com.scaler.productservice.dtos.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "users")
public class User extends BaseModel {

    private String userName;
    private String email;
    private String passwordHash;

    @ManyToMany
    private List<Role> roles;

    public UserDto getUserDto(){
        UserDto userDto = new UserDto();
        userDto.setId(this.getId());
        userDto.setName(this.getUserName());
        userDto.setEmail(this.getEmail());
        userDto.setRoles(this.getRoles());
        return userDto;
    }
}
