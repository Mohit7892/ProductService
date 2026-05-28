package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {
    private long Id;
    private String name;
    private String email;
    private List<Role> roles;
}
