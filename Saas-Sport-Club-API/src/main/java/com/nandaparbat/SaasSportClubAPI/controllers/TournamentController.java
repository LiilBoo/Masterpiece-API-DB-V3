package com.nandaparbat.SaasSportClubAPI.controllers;


import com.nandaparbat.SaasSportClubAPI.DTOs.*;
import com.nandaparbat.SaasSportClubAPI.services.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tournaments")
@RequiredArgsConstructor
public class TournamentController {

    private final TournamentService tournamentService;

    //* ------ GET REQUESTS -----------

    //* WORKS => DTO
    @GetMapping("/tour-cards")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentCardView> findAllTourCards(){
        return tournamentService.findAllToursCards();
    };


    //* WORKS => DTO
    @GetMapping("/with-id")
    @ResponseStatus(HttpStatus.OK)
    public TournamentView tourDetails(@RequestParam("id") Long id){
        return  tournamentService.findWithId(id);
    };


    //* WORKS => DTO
    @GetMapping("/events")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentViewCard> findAllByEventIsTrue(){
        return tournamentService.findAllByEventIsTrue();
    };

    //* WORKS => DTO
    // TODO : IgnoreCase => case insensitivity
    @GetMapping("/by-name")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentViewCard> findAllByNameIsContaining(@RequestParam("tourname") String tourName){
        return tournamentService.findAllByNameIsContaining(tourName);
    };

    //* WORKS => DTO
    @GetMapping("/by-contact")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentViewCard> findAllByContactContains(@RequestParam("contact") String contact){
        return tournamentService.findAllByContactContains(contact);
    };

    //* WORKS => DTO
    @GetMapping("/by-format")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentViewCard> findAllByFormatContains(@RequestParam("format") String formatName){
        return tournamentService.findAllByFormatContains(formatName);
    };


@GetMapping("/per-page")
@ResponseStatus(HttpStatus.OK)
public List<TournamentCardView> paginatePer10(@RequestParam("page") Long x) {
    return tournamentService.paginatePer10(x);
};
    // TODO : Per month ? => Time ? implement : Don't implent

    @GetMapping("my-tours")


    //* ---------- DELETE REQUESTS ----------------------------------

    //* WORKS
    @DeleteMapping("delete-id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWithId(@RequestParam("id") Long id) {
        tournamentService.deleteWithId(id);
    };

    //* ---------- PATCH REQUESTS ------------------------------

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update1Tournament(@RequestBody TournamentPatch inputs, @RequestParam("id") Long id){
        tournamentService.update1Tournament(inputs, id);
    };

    //! ---- CHECK LINE : CODE ABOVE WORKS ------------------------------------------------------ //

    //* -------- PUT REQUESTS
    //! Irrelevant ...
    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    public void overrideTournament(@RequestBody TournamentPatch inputs,
                                             @RequestParam("id") Long id){
        tournamentService.overrideTournament(inputs, id);
    };


    //* ---------- POST REQUEST

    //!FAILS
    @PostMapping("/create-tour")
    @ResponseStatus(HttpStatus.CREATED)
    public void tournamentCreate(@RequestBody TournamentCreate inputs){
        tournamentService.tournamentCreate(inputs);
    };






};
