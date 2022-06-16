package com.nandaparbat.SaasSportClubAPI.controllers;


import com.nandaparbat.SaasSportClubAPI.DTOs.*;
import com.nandaparbat.SaasSportClubAPI.entities.Tournament;
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

    //* ---------- CREATE REQUEST

    //*WORKS !!!!
    @PostMapping("/auth/create-tour")
    @ResponseStatus(HttpStatus.CREATED)
    public void tournamentCreate(@RequestBody TournamentCreate inputs){
        tournamentService.tournamentCreate(inputs);
    };

    //*READ REQUESTS

    @GetMapping("/users/tour-cards")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentCardView> findAllTourCards(){
        return tournamentService.findAllToursCards();
    };

    @GetMapping("/auth/list-admin-tournaments")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentNameView> listAdmintournaments(){
        return tournamentService.listAdminTournaments();
    };

    @GetMapping("/auth/list-participants")
    @ResponseStatus(HttpStatus.OK)
    public TournamentParticipantsDTO listTourParticipants(@RequestParam("id") Long id) {
        return tournamentService.listTourParticipants(id);
    };

    //*WORKS => DTO
    @GetMapping("/auth/my-tournaments")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentNameSQL> findMyToursByMyInfo(@RequestParam("id") Long id) {
        return tournamentService.findMyToursByMyInfo(id);
    };

    //* WORKS => DTO
    @GetMapping("/users/with-id")
    @ResponseStatus(HttpStatus.OK)
    public TournamentView tourDetails(@RequestParam("id") Long id){
        return  tournamentService.findWithId(id);
    };


    //* WORKS => DTO
    @GetMapping("/users/events")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentViewCard> findAllByEventIsTrue(){
        return tournamentService.findAllByEventIsTrue();
    };

    //* WORKS => DTO
    // TODO : IgnoreCase => case insensitivity
    @GetMapping("/users/by-name")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentViewCard> findAllByNameIsContaining(@RequestParam("tourname") String tourName){
        return tournamentService.findAllByNameIsContaining(tourName);
    };

    //* WORKS => DTO
    @GetMapping("/users/by-contact")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentViewCard> findAllByContactContains(@RequestParam("contact") String contact){
        return tournamentService.findAllByContactContains(contact);
    };

    //* WORKS => DTO
    @GetMapping("/users/by-format")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentViewCard> findAllByFormatContains(@RequestParam("format") String formatName){
        return tournamentService.findAllByFormatContains(formatName);
    };


@GetMapping("/users/per-page")
@ResponseStatus(HttpStatus.OK)
public List<TournamentCardView> paginatePer10(@RequestParam("page") Long x) {
    return tournamentService.paginatePer10(x);
};
    // TODO : Per month ? => Time ? implement : Don't implent

    //* ---------- DELETE REQUESTS ----------------------------------

    //* WORKS
    @DeleteMapping("/admin/delete-id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteWithId(@RequestParam("id") Long id) {
        tournamentService.deleteWithId(id);
    };


    //* ---------- PATCH REQUESTS ------------------------------

    @PatchMapping("/auth/update")
    @ResponseStatus(HttpStatus.OK)
    public void update1Tournament(@RequestBody TournamentPatch inputs, @RequestParam("id") Long id){
        tournamentService.update1Tournament(inputs, id);
    };

};
