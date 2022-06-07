package com.nandaparbat.SaasSportClubAPI.DTOs.players;

import com.nandaparbat.SaasSportClubAPI.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private java.lang.Long id;

    private String firstName;

    private String lastName;

    private int fideNumber;

    private int elo;

};
