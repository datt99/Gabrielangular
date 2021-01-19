package com.daniel.task_manager.Team.Repository.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer championships;

    public Team(String name, Integer championships) {
        this.name = name;
        this.championships = championships;
    }

}
