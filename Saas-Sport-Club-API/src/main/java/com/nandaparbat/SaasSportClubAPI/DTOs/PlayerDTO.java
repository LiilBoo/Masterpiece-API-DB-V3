package com.nandaparbat.SaasSportClubAPI.DTOs;

import com.nandaparbat.SaasSportClubAPI.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private java.lang.Long id;

    private String firstName;

    private String lastName;

    private int fideNumber;

    private int elo;

    //TODO : Collection of teams
    private Team uniqueTeam;

    //TODO : Collection of Roles

};
