package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.MyToursDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.PlayerCreate;
import com.nandaparbat.SaasSportClubAPI.DTOs.PlayerDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.PlayerSignIn;
import com.nandaparbat.SaasSportClubAPI.security.Jwt;

import java.util.List;

public interface PlayerService {

    //* ---- CREATE REQUEST
    void create(PlayerCreate inputs);

    //* AUTH REQUEST
    Jwt signIn(PlayerSignIn inputs);

    //* --- READ REQUESTS

    //Decode the token to retrieve workable data allowing us to find whose id
    List<MyToursDTO> myToursByMyId(Long id);

    //Decode the token to retrieve workable data allowing us to find whose id
    PlayerDTO myInfosByMyId(Long id);

    //* ---- UPDATE REQUEST

    //relevant retrieved data passed as argument
    void updateMyInfos(Long id);

    // relevant retrieved data
    void updateMyTours(Long id);

//    void updateMyTeams();


    //* --- DELETE REQUEST

    //! Call tournamentRepository to increase capacity/places by 1
    //! => requires new MCD and new table relationship with ManyToMany table that keep tracks of register
    void unregisterFromTournament(Long tourID, Long myPersonalId);

    //retrieve relevant data from token
    void deleteMyProfile(Long id);

    //same
    void deleteMeFromTeam(Long teamId, Long myId);

}
