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


    @PostMapping("create-pairing")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPairingStyle(@RequestBody PairingStyleDTO inputs) {

        pairingService.createPairingStyle(inputs);
    };



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



    @PatchMapping("/admin/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updatePairingStyle(@RequestBody PairingStyleDTO inputs, @RequestParam("id") Long id){
        pairingService.updatePairingStyle(inputs, id);
    };


    @DeleteMapping("/destroy")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deletePairingStyle(@RequestParam("id") Long id){
        pairingService.deletePairingStyle(id);
    };

};
