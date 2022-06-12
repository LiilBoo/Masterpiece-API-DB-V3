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
    @NotNull
    @FutureOrPresent
    private LocalDate dateOfStart;

    @NotBlank
    @NotNull
    @FutureOrPresent
    private LocalDate dateOfEnd;


    @Positive
    private int numberOfRounds;

    @Positive
    private Long formatId;

    @Positive
    private Long pairingId;

    @NotBlank
    @Size(min=5, max=100)
    private String organisator;

    @NotBlank
    private String contact; //personalUrl or email

    @Positive
    private Integer capacity;

    @PositiveOrZero
    private Integer firstPrice;

    @PositiveOrZero
    private Integer secondPrice;

    @PositiveOrZero
    private Integer thirdPrice;

    @PositiveOrZero
    private Integer registerFeeSenior;

    @PositiveOrZero
    private Integer registerFeeJunior;

    @NotBlank
    @Size(min=1, max=255)
    private String description;



};
