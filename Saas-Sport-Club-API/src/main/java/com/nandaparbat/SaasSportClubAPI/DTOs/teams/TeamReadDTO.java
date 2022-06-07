package com.nandaparbat.SaasSportClubAPI.DTOs.teams;

import com.nandaparbat.SaasSportClubAPI.DTOs.players.PlayerDTO;;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamReadDTO {

    private Long id;

    private String name;

    private List<PlayerDTO> players;


};
