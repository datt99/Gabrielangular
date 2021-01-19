package com.daniel.task_manager.User.Model;

import lombok.Data;

@Data
public class UserModel {
    private Long id;
    private String name;
    private String email;
    private String password;
}
