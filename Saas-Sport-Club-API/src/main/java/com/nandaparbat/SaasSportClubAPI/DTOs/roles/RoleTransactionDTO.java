package com.nandaparbat.SaasSportClubAPI.DTOs.roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleTransactionDTO {

    @NotEmpty
    @NotBlank
    private String name;
};
