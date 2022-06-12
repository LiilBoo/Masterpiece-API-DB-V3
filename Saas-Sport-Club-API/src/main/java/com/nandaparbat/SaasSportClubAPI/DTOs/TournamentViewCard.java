package com.nandaparbat.SaasSportClubAPI.DTOs;

import com.nandaparbat.SaasSportClubAPI.entities.Format;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentViewCard {

    private java.lang.Long id;

    private String name;

    private String format;

    private String pairingStyle;

    private Integer firstPrice;

    private Integer registerFeeSenior;

    private Integer registerFeeJunior;

    private String description;

};
