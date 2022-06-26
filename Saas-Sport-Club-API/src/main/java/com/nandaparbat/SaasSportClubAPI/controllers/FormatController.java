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


    @PostMapping("/admin/create-format")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFormat(@RequestBody FormatDTO inputs){
        formatService.createFormat(inputs);
    };



    @GetMapping("/users/all")
    @ResponseStatus(HttpStatus.OK)
    public List<FormatIDTO> allFormats(){
        return formatService.findAllProjectedBy();
    };

    @GetMapping("/admin/by-id")
    @ResponseStatus(HttpStatus.OK)
    public FormatDTO findFormatById(@RequestParam("id") Long id) {
        return formatService.findFormatById(id);
    };


    @GetMapping("/users/formatname")
    @ResponseStatus(HttpStatus.OK)
    public List<FormatIDTO> searchByName(@RequestParam("formatname") String formatName) {

        return formatService.findAllByNameEquals(formatName);
    };



    @PatchMapping("/admin/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateFormat(@RequestBody FormatDTO inputs, @RequestParam("id") Long id){
        formatService.updateFormat(inputs, id);
    };




    @DeleteMapping("delete-format")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFormat(@RequestParam("id") Long id){
        formatService.deleteFormat(id);
    };

};
