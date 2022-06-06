package com.nandaparbat.SaasSportClubAPI.controllers;

import com.nandaparbat.SaasSportClubAPI.DTOs.RoleIDTO;
import com.nandaparbat.SaasSportClubAPI.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    //TODO : Test postman
    //! if fail -> loss of information due to bad naming
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<RoleIDTO> listOfRoles(){
        return roleService.listOfRoles();
    };



};
