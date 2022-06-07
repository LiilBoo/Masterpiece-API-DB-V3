package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.players.*;
import com.nandaparbat.SaasSportClubAPI.entities.Player;
import com.nandaparbat.SaasSportClubAPI.entities.Role;
import com.nandaparbat.SaasSportClubAPI.repositories.PlayerRepository;
import com.nandaparbat.SaasSportClubAPI.repositories.RoleRepository;
import com.nandaparbat.SaasSportClubAPI.security.Jwt;
import com.nandaparbat.SaasSportClubAPI.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final RoleRepository roleRepository;

    private final PlayerRepository playerRepository;

    private final PasswordEncoder encoder;

    private final JwtProvider provider;



    //TODO : implement
    //TODO : decode token for id
    //* Motivated by a Front-End page
    @Override
    public List<MyToursDTO> myToursByMyId(Long id) {

        Player actualPlayer = playerRepository.getById(id);

        List<MyToursDTO> myTournaments = actualPlayer.getTournaments().stream().map(tour -> {
            MyToursDTO myTour = new MyToursDTO();
            myTour.setId(tour.getId());
            myTour.setName(tour.getName());
            myTour.setContact(tour.getContact());
            myTour.setFormat(tour.getFormat());

            return  myTour;
        }).collect(Collectors.toList());

        return myTournaments;
    };

    //*WORKS
    @Override
    public PlayerInfosDTO myInfosByMyId(Long id) {

        Player actualPlayer = playerRepository.getById(id);

        PlayerInfosDTO returnedInfos = new PlayerInfosDTO();

        returnedInfos.setElo(actualPlayer.getElo());

        returnedInfos.setFideNumber(actualPlayer.getFideNumber());

        returnedInfos.setFirstName(actualPlayer.getFirstName());

        returnedInfos.setLastName(actualPlayer.getLastName());

        returnedInfos.setUsername(actualPlayer.getUsername());

        List<PlayerMyTeamsDTO> myTeams = actualPlayer.getTeams().stream().map(team -> {

            PlayerMyTeamsDTO teamInfo = new PlayerMyTeamsDTO();

                teamInfo.setId(team.getId());
                teamInfo.setTeamName(team.getName());

                return teamInfo;
        }).collect(Collectors.toList());

        returnedInfos.setMyTeams(myTeams);

        List<PlayerMyToursDTO> myTours = actualPlayer.getTournaments().stream().map(tour -> {
            PlayerMyToursDTO tournament = new PlayerMyToursDTO();
            tournament.setId(tour.getId());
            tournament.setName(tour.getName());
            return tournament;
        }).collect(Collectors.toList());

        returnedInfos.setMyTours(myTours);

        return returnedInfos;
    };

    //*WORKS
    @Override
    public List<PlayerIDTO> listAllPlayers() {
        return playerRepository.findAllProjectedBy(PlayerIDTO.class);
    };

    //*WORKS
    @Override
    public List<PlayerEmailIDTO> listAllPlayersMail() {
        return playerRepository.findAllProjectedBy(PlayerEmailIDTO.class);
    };

    @Override
    public void updateMyInfos(PlayerTransactionDTO inputs, Long id) {

        Player player = playerRepository.getById(id);

    if((inputs.getFirstName() != null) &&
            (!inputs.getFirstName().isEmpty()) &&
            (!Objects.equals(player.getFirstName(),inputs.getFirstName()))){
        player.setFirstName(inputs.getFirstName());
    };

        if((inputs.getLastName() != null) &&
                (!inputs.getLastName().isEmpty()) &&
                (!Objects.equals(player.getLastName(),inputs.getLastName()))){
            player.setLastName(inputs.getLastName());
        };

        if((inputs.getUsername() != null) &&
                (!inputs.getUsername().isEmpty()) &&
                (!Objects.equals(player.getUsername(),inputs.getUsername()))){
            player.setUsername(inputs.getUsername());
        };

        if((inputs.getElo() > 769) &&
                (!Objects.equals(player.getElo(), inputs.getElo()))){
            player.setElo(inputs.getElo());
        };

        if((!Objects.equals(player.getFideNumber(), inputs.getFideNumber()))){
            player.setFideNumber(inputs.getFideNumber());
        };

        playerRepository.save(player);
    };

    @Override
    public void updateMyTours(Long id) {

    };

//    @Override
//    @Transactional
//    public void playerRoleSetting(@RequestParam("id") Long playerId, @RequestBody RoleSettingDTO roleBody) {
//        Player player = playerRepository.getById(playerId);
//        Role role = roleRepository.getById(roleBody.getRoleId());
//
//                      Long number = 1L;
//
//        if(!roleBody.getRoleId().equals(number) &&
//                (roleRepository.existsById(role.getId()))){
//            player.setRole(role);
//        };
//    };

    @Override
    public void unregisterFromTournament(Long tourID, Long myPersonalId) {

    };

    @Override
    public void deleteMyProfile(Long id) {
        Player player = playerRepository.getById(id);
        playerRepository.delete(player);
    };

    //? How to sync deletion so that both player and team are updated at the same time
    //TODO : Ask teacher
    // TODO : Ask Java wizards
    @Override
    public void deleteMeFromTeam(Long teamId, Long myId) {

    };




    //TODO : ADD Business logic : fide elo, fide number, firstname, lastname,

    //! AUTH
    //! DONT MODIFY
    //!-------------------
    @Transactional
    @Override
    public void create(PlayerCreate inputs){
        Player player = new Player();
        player.setUsername(inputs.getUsername());

        String encoded = encoder.encode(inputs.getPassword());
        player.setPassword(encoded);

        //*-------------------
        player.setFirstName(inputs.getFirstName());
        player.setLastName(inputs.getLastName());
        player.setElo(inputs.getElo());
        player.setFideNumber(inputs.getFideNumber());
        //*-------------------



        playerRepository.save(player);
    };
    @Override
    public Jwt signIn(PlayerSignIn inputs) {

        String username = inputs.getUsername();
        Player player =
                playerRepository.findByUsernameIgnoreCase(username).orElseThrow(
                    () -> new BadCredentialsException(String.format("password does not match for username '%s' ", username)
                        )
                );

        String password = inputs.getPassword();

        if(!encoder.matches(password, player.getPassword() )){
            throw new BadCredentialsException(String.format("password does " +
                    "not match username '%s' ", username));
        };

        Role role = player.getRole();

        List<String> roles = null;

        if(role != null){
            roles = List.of(role.getRoleName());
        };

        return provider.create(String.valueOf(player.getId()), roles);
    }
    //!---------- AUTH ------------
    //! DONT CHANGE

};
