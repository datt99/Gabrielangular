package com.daniel.task_manager.Team.Controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamModel {

    private String name;
    private Integer championships;

    public TeamModel(String name, Integer championships) {
        this.name = name;
        this.championships = championships;
    }
}
