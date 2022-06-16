package com.nandaparbat.SaasSportClubAPI.controllers;


import com.nandaparbat.SaasSportClubAPI.DTOs.pairing.PairingStyleDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.pairing.PairingStyleIDTO;
import com.nandaparbat.SaasSportClubAPI.services.PairingStyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pairing-styles")
@RequiredArgsConstructor
public class PairingStyleController {

    private final PairingStyleService pairingService;

    //* ---- CREATE REQUEST
    //TODO : TEST ALL ENDPOINTS

    @PostMapping("create-pairing")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPairingStyle(@RequestBody PairingStyleDTO inputs) {

        pairingService.createPairingStyle(inputs);
    };

    //* ---- READ REQUEST

    @GetMapping("/users/list")
    @ResponseStatus(HttpStatus.OK)
    public List<PairingStyleIDTO> listOfPairings(){
        return pairingService.listOfPairings();
    };

    @GetMapping("/admin/with-id")
    @ResponseStatus(HttpStatus.OK)
    public PairingStyleDTO findPairingStyleById(@RequestParam Long id){
        return pairingService.findPairingStyleById(id);
    };

    //* ---- UPDATE REQUEST

    @PatchMapping("/admin/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updatePairingStyle(@RequestBody PairingStyleDTO inputs, @RequestParam("id") Long id){
        pairingService.updatePairingStyle(inputs, id);
    };

    //* --- DELETE REQUEST

    //! Violates foreign key constraint
    //! against business logic to every delete a style, even when no tournaments references it
    // TODO : Keep ? Ask teacher
    @DeleteMapping("/destroy")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deletePairingStyle(@RequestParam("id") Long id){
        pairingService.deletePairingStyle(id);
    };

};
