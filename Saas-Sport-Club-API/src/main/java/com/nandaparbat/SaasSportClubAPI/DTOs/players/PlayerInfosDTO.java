package com.nandaparbat.SaasSportClubAPI.DTOs.players;

import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamNameIDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInfosDTO {


    private String firstName;

    private String lastName;

    private int fideNumber;

    private int elo;

    private String username;

   private List<PlayerMyTeamsDTO> myTeams;

   private List<PlayerMyToursDTO> myTours;
};
