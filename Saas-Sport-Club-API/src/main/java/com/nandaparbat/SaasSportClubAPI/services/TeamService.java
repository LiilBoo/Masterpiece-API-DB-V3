package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamReadDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamTransactionDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamIDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamNameIDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeamService {

    //* CREATE REQUEST
    void createTeam(@RequestBody TeamTransactionDTO inputs);

    //* READ REQUESTS
    List<TeamIDTO> listAllTeams();

    List<TeamNameIDTO> listAllTeamNames();

    TeamReadDTO getTeamById(@RequestParam("id") Long id);

    //*UPDATE REQUESTS

    void updateTeam(@RequestParam("id") Long id, @RequestBody TeamTransactionDTO inputs);

    //* DELETE REQUESTS

    void deleteTeam(@RequestParam("id") Long id);

};
