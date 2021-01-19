package com.daniel.task_manager.Team.Controller;

import com.daniel.task_manager.Team.Repository.Entity.Team;
import com.daniel.task_manager.Team.Repository.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("teams")
@CrossOrigin("*")
public class TeamsController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping
    public ResponseEntity saveTeam(@RequestBody TeamModel teamModel) {
        Team team = new Team(teamModel.getName(), teamModel.getChampionships());
        return ResponseEntity.ok(teamRepository.save(team));
    }

    @PutMapping("{id}")
    public ResponseEntity updateTeam(@RequestBody TeamModel teamModel, @PathVariable(name = "id") Long id) {

        Optional<Team> optionalTeam = teamRepository.findById(id);

        if (!optionalTeam.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Team team = new Team(teamModel.getName(), teamModel.getChampionships());
        team.setId(optionalTeam.get().getId());

        return ResponseEntity.ok(teamRepository.save(team));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTeam(@PathVariable("id") Long id) {
        teamRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getTeams() {
        return ResponseEntity.ok(teamRepository.findAll());
    }

}
