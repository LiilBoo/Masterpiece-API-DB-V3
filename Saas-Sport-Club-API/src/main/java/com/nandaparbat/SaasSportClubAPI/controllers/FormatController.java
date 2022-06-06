package com.nandaparbat.SaasSportClubAPI.controllers;

import com.nandaparbat.SaasSportClubAPI.DTOs.formats.FormatDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.formats.FormatIDTO;
import com.nandaparbat.SaasSportClubAPI.services.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formats")
@RequiredArgsConstructor
public class FormatController {

    private final FormatService formatService;


    //* --- CRUD : CREATE  --- POSTS REQUESTS

    @PostMapping("create-format")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFormat(@RequestBody FormatDTO inputs){
        formatService.createFormat(inputs);
    };

    //* READ --- GET REQUESTS

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<FormatIDTO> allFormats(){
        return formatService.findAllProjectedBy();
    };

    @GetMapping("/by-id")
    @ResponseStatus(HttpStatus.OK)
    public FormatDTO findFormatById(@RequestParam("id") Long id) {
        return formatService.findFormatById(id);
    };

    //TODO : case sensitivity
    @GetMapping("/formatname")
    @ResponseStatus(HttpStatus.OK)
    public List<FormatIDTO> searchByName(@RequestParam("formatname") String formatName) {

        return formatService.findAllByNameEquals(formatName);
    };

    //* UPDATE --- PATCH REQUESTS

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateFormat(@RequestBody FormatDTO inputs, @RequestParam("id") Long id){
        formatService.updateFormat(inputs, id);
    };



    //* CRUD : DELETE --- DELETE REQUESTS

    //! Goes against business logic to delete formats
    //! Formats are tied to tournaments and tournaments can't have null format
    @DeleteMapping("delete-format")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFormat(@RequestParam("id") Long id){
        formatService.deleteFormat(id);
    };

};
