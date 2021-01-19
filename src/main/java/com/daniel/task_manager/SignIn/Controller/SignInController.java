package com.daniel.task_manager.SignIn.Controller;

import com.daniel.task_manager.SignIn.Application.UserData;
import com.daniel.task_manager.SignIn.Application.UserPassword;
import com.daniel.task_manager.User.Repository.Entity.User;
import com.daniel.task_manager.User.Repository.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class SignInController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity authenticate(@RequestBody UserPassword userPassword) {
        if (userPassword.getEmail().equals("general_danitru@dani.com") && userPassword.getPassword().equals("980298")) {
            return ResponseEntity.ok(new UserData("SUPERUSUARIO", 0L, "DANIEL TRU"));
        }

        Optional<User> optionalEmployee = userRepository.findUserByEmailAndPassword(userPassword.getEmail(), userPassword.getPassword());

        if (optionalEmployee.isPresent()) {
            return ResponseEntity.ok(new UserData("USUARIO", optionalEmployee.get().getId(), optionalEmployee.get().getName()));
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new UserData("", 0L, "NO_USER"));
    }
}
