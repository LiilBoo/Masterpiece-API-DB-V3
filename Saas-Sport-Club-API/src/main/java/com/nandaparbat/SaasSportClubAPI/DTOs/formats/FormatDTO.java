package com.nandaparbat.SaasSportClubAPI.DTOs.formats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormatDTO {

    @NotEmpty
    @NotBlank
    private String name;

}
