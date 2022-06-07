package com.nandaparbat.SaasSportClubAPI.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentNameView {

    private Long id;

    private String name;

    private String format;

    private String contact;
};
