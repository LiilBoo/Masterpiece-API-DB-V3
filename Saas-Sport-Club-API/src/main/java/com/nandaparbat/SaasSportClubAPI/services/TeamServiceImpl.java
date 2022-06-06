package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamIDTO;
import com.nandaparbat.SaasSportClubAPI.entities.Team;
import com.nandaparbat.SaasSportClubAPI.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    //* CREATE REQUEST

    //TODO : Test
    @Override
    public void createTeam(@Valid @RequestBody TeamDTO inputs) {
        Team newTeam = new Team();
        newTeam.setName(inputs.getTeamName());
        newTeam.setPlayers(inputs.getTeamPlayers());
        teamRepository.save(newTeam);
    };

    //* READ REQUESTS

    //TODO : Test
    // TODO : Add validations
    @Override
    public List<TeamIDTO> listAllTeams() {
        return teamRepository.findAllProjectedBy(TeamIDTO.class);
    };

    //TODO : Test
    // TODO : Add validation
    @Override
    public TeamDTO getTeamById(@RequestParam("id") Long id) {

        Team team = teamRepository.getById(id);

        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setId(team.getId());
        teamDTO.setTeamName(team.getName());
        teamDTO.setTeamPlayers(team.getPlayers());

        return teamDTO;
    };

    //TODO : Test
    // TODO : Add validations
    @Override
    public void updateTeam(@RequestParam("id") Long id, @RequestBody TeamDTO inputs) {

        Team team = teamRepository.getById(id);

        team.setName(inputs.getTeamName());
        team.setPlayers(inputs.getTeamPlayers());

        teamRepository.save(team);
    };

    // TODO : test
    // TODO : Add validation
    @Override
    public void deleteTeam(@RequestParam("id") Long id) {
        teamRepository.delete(teamRepository.getById(id));
    };
};
