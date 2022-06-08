package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.*;
import com.nandaparbat.SaasSportClubAPI.entities.Tournament;

import java.util.List;


public interface TournamentService {

    //* -------- POST requests
    void tournamentCreate(TournamentCreate inputs);

    //* ------ Get requests ------ //

    //* WORKS
    TournamentView findWithId(Long id);

    //* WORKS => DTO => Front-end Home Page
    List<TournamentCardView> findAllToursCards();

    //*WORKS
    List<TournamentNameView> listAdminTournaments();

    //*WORKS
    TournamentParticipantsDTO listTourParticipants(Long id);

    List<TournamentNameSQL> findMyToursByMyInfo(Long id);

    //* WORKS => DTO
    List<TournamentViewCard> findAllByEventIsTrue();

    //* WORKS => DTO
    List<TournamentViewCard> findAllByContactContains(String contact);

    //* WORKS => DTO
    List<TournamentViewCard> findAllByNameIsContaining(String name);

    //* WORKS => DTO
    List<TournamentViewCard> findAllByFormatContains(String formatName);

    //* WORKS => DTO
    // TODO : Refactor format and Pairing to String ?
    List<TournamentCardView> paginatePer10(Long x);

    //*--------- DELETE requests -------------

    //* WORKS
    void deleteWithId(Long id);

    //* -- PATCH Requests ✅
    //*WORKS
    void update1Tournament(TournamentPatch inputs, Long id);

    // ! --------- CHECK LINE ---------- //


    void overrideTournament(TournamentPatch inputs, Long id);


    //* -- PUT Requests
}
