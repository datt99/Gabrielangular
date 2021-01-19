package com.daniel.task_manager.SignIn.Application;

import lombok.Data;

@Data
public class UserData {


    private final Long id;
    private final String rol;
    private final String name;

    public UserData(String rol, Long id, String name) {
        this.rol = rol;
        this.id = id;
        this.name = name;
    }
}
