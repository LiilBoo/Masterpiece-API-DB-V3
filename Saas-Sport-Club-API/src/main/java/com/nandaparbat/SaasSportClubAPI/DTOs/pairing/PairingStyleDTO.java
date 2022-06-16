package com.nandaparbat.SaasSportClubAPI.DTOs.pairing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PairingStyleDTO {

    @NotEmpty
    @NotBlank
    private String name;

    private Long id;

};
