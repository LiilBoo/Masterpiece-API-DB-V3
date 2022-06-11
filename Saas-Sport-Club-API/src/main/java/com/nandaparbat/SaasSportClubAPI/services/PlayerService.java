package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.players.*;
import com.nandaparbat.SaasSportClubAPI.security.Jwt;

import java.util.List;

public interface PlayerService {

    //* ---- CREATE REQUEST
    void create(PlayerCreate inputs);

    //* AUTH REQUEST
    Jwt signIn(PlayerSignIn inputs);

    //* --- READ REQUESTS

    //Decode the token to retrieve workable data allowing us to find whose id
    //*WORKS
    List<MyToursDTO> myToursByMyId(Long id);

    //*WORKS
    List<MyTeamsDTO> myTeamsByMyId(Long id);

    //TODO : Decode the token to retrieve workable data allowing us to find whose id
    //*WORKS
    PlayerInfosDTO myInfosByMyId(Long id);

    //*WORKS
    List<PlayerIDTO> listAllPlayers();

    //*WORKS
    List<PlayerEmailIDTO> listAllPlayersMail();

    //* ---- UPDATE REQUEST

    //relevant retrieved data passed as argument
    void updateMyInfos(PlayerTransactionDTO inputs,Long id);

    // relevant retrieved data
    void registerToTournament(Long tourId, Long playerId);




    //* --- ADMIN REQUESTS Relative to users

//    public void playerRoleSetting(@RequestParam("id") Long playerId, @RequestBody RoleSettingDTO roleBody);

    //* --- DELETE REQUEST

    //! Call tournamentRepository to increase capacity/places by 1
    //! => requires new MCD and new table relationship with ManyToMany table that keep tracks of register
    void unregisterFromTournament(Long tourID, Long myPersonalId);

    //retrieve relevant data from token
    void deleteMyProfile(Long id);

    //same
    void deleteMeFromTeam(Long teamId, Long myId);

}
