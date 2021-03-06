package com.nandaparbat.SaasSportClubAPI.controllers;

import com.nandaparbat.SaasSportClubAPI.DTOs.roles.RoleIDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.roles.RoleTransactionDTO;
import com.nandaparbat.SaasSportClubAPI.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @PostMapping("/create-role")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@RequestBody RoleTransactionDTO inputs){
        roleService.createRole(inputs);
    };


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<RoleIDTO> listOfRoles(){
        return roleService.listOfRoles();
    };

    @PatchMapping("/update-role")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRole(@RequestBody RoleTransactionDTO inputs, @RequestParam("id") Long id){
        roleService.updateRole(inputs, id);
    };


    @DeleteMapping("delete-role")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRole(@RequestParam("id") Long id){
        roleService.deleteRole(id);
    };


};
