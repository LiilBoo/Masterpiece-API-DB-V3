package com.nandaparbat.SaasSportClubAPI.DTOs.teams;

import com.nandaparbat.SaasSportClubAPI.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamTransactionDTO {


    private String teamName;

    //! Maximum 8 players validation
    //! Verify the players exist !!!
    private List<Player> teamPlayers;

};
