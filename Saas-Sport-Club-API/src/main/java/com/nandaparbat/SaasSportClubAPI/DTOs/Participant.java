package com.nandaparbat.SaasSportClubAPI.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    private Long id;

    private String username;

    private int fideNumber;

    private int elo;
};
