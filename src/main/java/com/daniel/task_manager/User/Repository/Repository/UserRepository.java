package com.daniel.task_manager.User.Repository.Repository;

import com.daniel.task_manager.User.Repository.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User e WHERE e.email=?1 and e.password = ?2")
    Optional<User> findUserByEmailAndPassword(String email, String password);
}
