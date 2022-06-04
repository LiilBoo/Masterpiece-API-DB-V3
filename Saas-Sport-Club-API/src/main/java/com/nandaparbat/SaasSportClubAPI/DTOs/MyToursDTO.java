package com.nandaparbat.SaasSportClubAPI.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyToursDTO {

    //! Cannot implement before a player can save the tournaments he wants to register
    //! registering is read-only there's no payment or mail
    //! organisator should be notified or see a change of data => capacity

    private java.lang.Long id;

    private String name;

    private String format;

    private String contact;

};
