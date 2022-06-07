package com.nandaparbat.SaasSportClubAPI.DTOs.teams;


import com.nandaparbat.SaasSportClubAPI.DTOs.players.PlayerIDTO;


import java.util.List;

public interface TeamIDTO {

    Long getId();

    String getName();

    List<PlayerIDTO> getPlayers();

};
