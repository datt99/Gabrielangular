package com.daniel.task_manager.User.Controller;

import com.daniel.task_manager.User.Model.UserModel;
import com.daniel.task_manager.User.Repository.Entity.User;
import com.daniel.task_manager.User.Repository.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
        User user = new User(userModel.getEmail(), userModel.getName(), userModel.getPassword());
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PutMapping("{id}")
    public ResponseEntity updateUser(@RequestBody UserModel userModel, @PathVariable(name = "id") Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        User user = optionalUser.get();
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setName(userModel.getName());
        return ResponseEntity.ok(userRepository.save(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable(name = "id") Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
