package com.nandaparbat.SaasSportClubAPI.DTOs.players;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//! Spring relies on the constructor to create the object at runtime and do magic

@Data
@NoArgsConstructor
public class PlayerCreate {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String firstName;

    private String lastName;

    @NotNull
    private int fideNumber;

    private int elo;

    @Override
    public String toString() {
        return String.format("{username=%s, password=%s}", username,
                "[PROTECTED]");
    };

};
