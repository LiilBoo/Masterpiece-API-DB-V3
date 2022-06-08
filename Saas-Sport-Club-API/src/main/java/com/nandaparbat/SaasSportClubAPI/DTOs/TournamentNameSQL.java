package com.nandaparbat.SaasSportClubAPI.DTOs;

import com.nandaparbat.SaasSportClubAPI.entities.Format;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface TournamentNameSQL {

    Long getId();

    String getName();

    Integer getFormat();

    String getContact();

//    private Long id;
//
//    private String tournament_name;
//
//    private Format format;
//
//    private String contact;
};
