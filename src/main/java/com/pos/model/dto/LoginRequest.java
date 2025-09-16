package com.pos.model.dto;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NonNull
    private String name;

    @NonNull
    private String password;
}
