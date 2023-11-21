package com.aguerecoders.agueredockergui.entity;

import lombok.Getter;

@Getter
public class UserEntity {

    private long id;
    private final String name;
    private final String email;
    private final String password;

    public UserEntity(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
