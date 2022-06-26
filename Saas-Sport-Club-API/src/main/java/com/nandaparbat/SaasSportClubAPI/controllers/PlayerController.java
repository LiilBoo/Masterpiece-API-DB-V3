package com.nandaparbat.SaasSportClubAPI.controllers;

import com.nandaparbat.SaasSportClubAPI.DTOs.players.*;
import com.nandaparbat.SaasSportClubAPI.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.nandaparbat.SaasSportClubAPI.security.Jwt;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;



    @GetMapping("/users/my-tours")
    @ResponseStatus(HttpStatus.OK)
    public List<MyToursDTO> myToursByMyId(@RequestParam("id") Long id){
        return playerService.myToursByMyId(id);
    };

    @GetMapping("/users/my-teams")
    @ResponseStatus(HttpStatus.OK)
    public List<MyTeamsDTO> myTeamsByMyId(@RequestParam("id") Long id){
        return playerService.myTeamsByMyId(id);
    };


    @GetMapping("/users/my-infos")
    @ResponseStatus(HttpStatus.OK)
    public PlayerInfosDTO myInfosByMyId(@RequestParam("id") Long id){
        return playerService.myInfosByMyId(id);
    };

    @GetMapping("/users/register-to-tour")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registerToTournament(@RequestParam("tourId") Long tourId,
                                     @RequestParam("myPersonalId") Long myPersonalId){

         playerService.registerToTournament(tourId, myPersonalId);
    };

    @GetMapping("/users/unregister-to-tour")
    public void unregisterToTournament(@RequestParam("tourId")Long tourId,
                                       @RequestParam("myPersonalId")Long playerId){
        playerService.unregisterToTournament(tourId, playerId);
    };


    @GetMapping("/all-players")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerIDTO> listAllPlayers(){
       return playerService.listAllPlayers();
    };


    @PatchMapping("/users/update-profile")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateMyInfos(@Valid @RequestBody PlayerTransactionDTO inputs, @RequestParam("id") Long id){
        playerService.updateMyInfos(inputs, id);
    };



    @DeleteMapping("/delete-profile")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteMyProfile(@RequestParam("id") Long id){
        playerService.deleteMyProfile(id);
    };

    @PostMapping("/users/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PlayerCreate inputs){
        playerService.create(inputs);
    };


    @PostMapping("/users/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public Jwt signIn(@RequestBody PlayerSignIn inputs){
        return playerService.signIn(inputs);
    };
};
