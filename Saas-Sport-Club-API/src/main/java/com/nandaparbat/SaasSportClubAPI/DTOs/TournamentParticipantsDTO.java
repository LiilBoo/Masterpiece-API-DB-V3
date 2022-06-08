package com.nandaparbat.SaasSportClubAPI.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentParticipantsDTO {

    private Long id;

    private String name;

    private List<Participant> participants;

};
