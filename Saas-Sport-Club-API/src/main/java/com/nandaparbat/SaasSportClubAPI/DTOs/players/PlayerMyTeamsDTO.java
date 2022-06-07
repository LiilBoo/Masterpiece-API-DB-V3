package com.nandaparbat.SaasSportClubAPI.DTOs.players;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerMyTeamsDTO {
    private Long id;

    private String teamName;
};
