package com.aguerecoders.agueredockergui.entity;

import lombok.Getter;

@Getter
public class UserEntity {

    private long id;
    private String name;
    private String email;
    private String password;

    public UserEntity() {
    }

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
