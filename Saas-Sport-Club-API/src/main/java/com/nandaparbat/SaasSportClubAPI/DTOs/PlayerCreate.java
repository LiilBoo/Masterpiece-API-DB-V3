package com.nandaparbat.SaasSportClubAPI.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

//! Spring relies on the constructor to create the object at runtime and do magic

@Data
@NoArgsConstructor
public class PlayerCreate {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private int fideNumber;

    private int elo;

    @Override
    public String toString() {
        return String.format("{username=%s, password=%s}", username,
                "[PROTECTED]");
    };

};
