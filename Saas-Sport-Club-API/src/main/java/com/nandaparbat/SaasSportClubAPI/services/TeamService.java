package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamIDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeamService {

    //* CREATE REQUEST
    void createTeam(@RequestBody TeamDTO inputs);

    //* READ REQUESTS
    List<TeamIDTO> listAllTeams();

    TeamDTO getTeamById(@RequestParam("id") Long id);

    //*UPDATE REQUESTS

    void updateTeam(@RequestParam("id") Long id, @RequestBody TeamDTO inputs);

    //* DELETE REQUESTS

    void deleteTeam(@RequestParam("id") Long id);

};
