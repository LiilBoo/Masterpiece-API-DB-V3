package com.nandaparbat.SaasSportClubAPI.controllers;

import com.nandaparbat.SaasSportClubAPI.DTOs.players.*;
import com.nandaparbat.SaasSportClubAPI.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.nandaparbat.SaasSportClubAPI.security.Jwt;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    //*READ REQUESTS

    //*WORKS
    @GetMapping("/my-tours")
    @ResponseStatus(HttpStatus.OK)
    public List<MyToursDTO> myToursByMyId(@RequestParam("id") Long id){
        return playerService.myToursByMyId(id);
    };

    //*WORKS
    @GetMapping("/my-infos")
    @ResponseStatus(HttpStatus.OK)
    public PlayerInfosDTO myInfosByMyId(@RequestParam("id") Long id){
        return playerService.myInfosByMyId(id);
    };

    @GetMapping("/register-to-tour")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registerToTournament(@RequestParam("tourId") Long tourId,
                                     @RequestParam("myPersonalId") Long myPersonalId){

         playerService.registerToTournament(tourId, myPersonalId);
    };

    //*WORKS
    @GetMapping("/all-players")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerIDTO> listAllPlayers(){
       return playerService.listAllPlayers();
    };

    //*WORKS
    @GetMapping("/list-mails")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerEmailIDTO> listAllPlayersMail(){
        return playerService.listAllPlayersMail();
    };

    //*UPDATE REQUEST

    //*WORKS
    @PatchMapping("/update-profile")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateMyInfos(@RequestBody PlayerTransactionDTO inputs, @RequestParam("id") Long id){
        playerService.updateMyInfos(inputs, id);
    };
    //* DELETE REQUESTS

    //*WORKS
    @DeleteMapping("/delete-profile")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteMyProfile(@RequestParam("id") Long id){
        playerService.deleteMyProfile(id);
    };





















    //*WORKS
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PlayerCreate inputs){
        playerService.create(inputs);
    };

    //*WORKS
    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public Jwt signIn(@RequestBody PlayerSignIn inputs){
        return playerService.signIn(inputs);
    };
};
