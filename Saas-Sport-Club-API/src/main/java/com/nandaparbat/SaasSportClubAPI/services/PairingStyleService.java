package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.pairing.PairingStyleDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.pairing.PairingStyleIDTO;

import java.util.List;

public interface PairingStyleService {

    //* ----- CREATE REQUEST

    void createPairingStyle(PairingStyleDTO inputs);

    //* ----- READ REQUESTS -------

    //*Perfect
    PairingStyleDTO findPairingStyleById(Long id);

    //*Perfect
    List<PairingStyleIDTO> listOfPairings();

    //* --- UPDATE REQUEST -----
    void updatePairingStyle(PairingStyleDTO inputs, Long id);

    //* ------- DELETE REQUEST ----
    void deletePairingStyle(Long id);

};
