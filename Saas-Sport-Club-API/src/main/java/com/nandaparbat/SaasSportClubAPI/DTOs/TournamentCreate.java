package com.nandaparbat.SaasSportClubAPI.DTOs;

import com.nandaparbat.SaasSportClubAPI.entities.Format;
import com.nandaparbat.SaasSportClubAPI.entities.PairingStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentCreate {


    @NotBlank
    private String name;

    @NotBlank
    private LocalDate dateOfStart;

    private LocalDate dateOfEnd;

    // TODO : works ?
    @Min(1)
    private int numberOfRounds;

    private Long formatId;

    private Long pairingId;

    @NotBlank
    @Size(min=5, max=100)
    private String organisator;

    private String contact; //personalUrl or email

    private Integer capacity;

    private Integer firstPrice;
    //TODO : postgreSQL does not autocomplete to BIGINT;

    private Integer secondPrice;

    private Integer thirdPrice;

    private Integer registerFeeSenior;

    private Integer registerFeeJunior;

    @NotBlank
    @Size(min=1, max=255)
    private String description;



};
