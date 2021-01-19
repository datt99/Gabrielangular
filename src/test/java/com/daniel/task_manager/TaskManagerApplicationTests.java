package com.daniel.task_manager;

import com.daniel.task_manager.User.Repository.Entity.User;
import com.daniel.task_manager.User.Repository.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {com.daniel.task_manager.TaskManagerApplication.class})
class TaskManagerApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

}
