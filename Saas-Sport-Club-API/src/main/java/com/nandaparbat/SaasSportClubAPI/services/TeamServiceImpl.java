package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.players.PlayerDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamReadDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamTransactionDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamIDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamNameIDTO;
import com.nandaparbat.SaasSportClubAPI.entities.Player;
import com.nandaparbat.SaasSportClubAPI.entities.Team;
import com.nandaparbat.SaasSportClubAPI.repositories.PlayerRepository;
import com.nandaparbat.SaasSportClubAPI.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    private final PlayerRepository playerRepository;

    //* CREATE REQUEST

    //TODO : Test
    //TODO:  VERIFY Players exist
    @Override
    public void createTeam(@Valid @RequestBody TeamTransactionDTO inputs) {
        Team newTeam = new Team();
        newTeam.setName(inputs.getTeamName());
        //TODO: Test a practical case from Front-end
        //*----- verifying players exist
//        List<Player> realPlayers =
//                inputs.getTeamPlayers().stream().filter(
//                 player ->   (player != null) && (playerRepository.getById(player.getId()) != null)
//                ).collect(Collectors.toList());
        //*-------

        newTeam.setPlayers(inputs.getTeamPlayers());
        teamRepository.save(newTeam);
    };

    //* READ REQUESTS

    //* WORKS !
    //! Has caused StackOverflow error in previous version
    @Override
    public List<TeamIDTO> listAllTeams() {
        return teamRepository.findAllProjectedBy(TeamIDTO.class);
    };

    //* WORKS
    @Override
    public List<TeamNameIDTO> listAllTeamNames() {
        return teamRepository.findAllProjectedBy(TeamNameIDTO.class);
    };

    //*WORKS
    // TODO : Add validation
    @Override
    public TeamReadDTO getTeamById(@RequestParam("id") Long id) {

        Team team = teamRepository.getById(id);

        TeamReadDTO teamDTO = new TeamReadDTO();

        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());

        List<Player> teamPlayers = team.getPlayers();

       List<PlayerDTO> teamPlayersDTO = teamPlayers.stream().map(player -> {
           PlayerDTO newPlayer = new PlayerDTO();
           newPlayer.setFirstName(player.getFirstName());
           newPlayer.setLastName(player.getLastName());
           newPlayer.setFideNumber(player.getFideNumber());
           newPlayer.setUsername(player.getUsername());
           newPlayer.setElo(player.getElo());
           newPlayer.setId(player.getId());


           return newPlayer;
        }).collect(Collectors.toList());

        teamDTO.setPlayers(teamPlayersDTO);

        return teamDTO;
    };

    //TODO : Test
    // TODO : Add validations
    @Override
    public void updateTeam(@RequestParam("id") Long id, @RequestBody TeamTransactionDTO inputs) {

        Team team = teamRepository.getById(id);

        team.setName(inputs.getTeamName());
        team.setPlayers(inputs.getTeamPlayers());

        teamRepository.save(team);
    };

    //*WORKS
    // TODO : Add validation
    @Override
    public void deleteTeam(@RequestParam("id") Long id) {
        teamRepository.delete(teamRepository.getById(id));
    };
};
