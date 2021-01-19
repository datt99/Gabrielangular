package com.daniel.task_manager.Team.Repository.Repository;

import com.daniel.task_manager.Team.Repository.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
