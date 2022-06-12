package com.nandaparbat.SaasSportClubAPI.DTOs.teams;

import com.nandaparbat.SaasSportClubAPI.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamTransactionDTO {

    @NotBlank
    private String teamName;

    @Size(min=4, max=8)
    private List<Player> teamPlayers;

};
