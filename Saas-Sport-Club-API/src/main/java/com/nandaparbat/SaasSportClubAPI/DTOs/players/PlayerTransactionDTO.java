package com.nandaparbat.SaasSportClubAPI.DTOs.players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerTransactionDTO {

    private String firstName;

    private String lastName;

    private int fideNumber;

    private int elo;

    private String username;

    //? might be another function
//    private List<PlayerMyTeamsDTO> myTeams;
}
