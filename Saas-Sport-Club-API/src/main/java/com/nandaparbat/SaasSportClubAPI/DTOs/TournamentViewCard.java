package com.nandaparbat.SaasSportClubAPI.DTOs;

import com.nandaparbat.SaasSportClubAPI.entities.Format;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentViewCard {

//    //!CONSTRUCTOR FOR CONTACT/FORMAT @Queries
//    public TournamentViewCard(Long id,
//                          String name,
//                          String format,
//                          String pairingStyle,
//                          Integer firstPrice,
//                          Integer registerFeeSenior,
//                          Integer registerFeeJunior,
//                          String description) {
//        this.id = id;
//        this.name = name;
//        this.format = format;
//        this.pairingStyle = pairingStyle;
//        this.firstPrice = firstPrice;
//        this.registerFeeSenior = registerFeeSenior;
//        this.registerFeeJunior = registerFeeJunior;
//        this.description = description;
//    }

    private java.lang.Long id;

    private String name;

    private String format;

    private String pairingStyle;

    private Integer firstPrice;

    private Integer registerFeeSenior;

    private Integer registerFeeJunior;

    private String description;

};
