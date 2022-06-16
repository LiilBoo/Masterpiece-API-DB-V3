package com.nandaparbat.SaasSportClubAPI.controllers;

import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamReadDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamTransactionDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamIDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.teams.TeamNameIDTO;
import com.nandaparbat.SaasSportClubAPI.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    //* CREATE REQUEST
    //TODO : Add validation -> Max 8 players -> verify players exist
    @PostMapping("/admin/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeam(@Valid @RequestBody TeamTransactionDTO inputs){
        teamService.createTeam(inputs);
    };

    //* READ REQUESTS


    //TODO : Read doc about @JsonIgnore
    // TODO : learn Request recursivity
    // TODO : Learn stream API
    //* WORKS
    @GetMapping("/admin/list-all")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamIDTO> listAllTeams(){
        return teamService.listAllTeams();
    };
    //! Causes StackOverflow error :
    //! Teams gets -> players which displays their teams
    //! Which triggers their teams
    //! their teams gets -> players which displays their teams
    //! And so on

    //
//    ava.lang.StackOverflowError: null
//    at java.base/java.util.concurrent.ConcurrentHashMap.putIfAbsent(ConcurrentHashMap.java:1541) ~[na:na]
//    at java.base/java.lang.ClassLoader.getClassLoadingLock(ClassLoader.java:668) ~[na:na]
//    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:591) ~[na:na]
//    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:579) ~[na:na]
//    at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178) ~[na:na]
//    at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522) ~[na:na]
//    at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774) ~[jackson-databind-2.13.3.jar:2.13.3]
//    at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178) ~[jackson-databind-2.13.3.jar:2.13.3]
//    at com.fasterxml.jackson.databind.ser.std.CollectionSerializer.serializeContents(CollectionSerializer.java:145) ~[jackson-databind-2.13.3.jar:2.13.3]
//    at com.fasterxml.jackson.databind.ser.std.CollectionSerializer.serialize(CollectionSerializer.java:107) ~[jackson-databind-2.13.3.jar:2.13.3]
    //

    //* WORKS
    @GetMapping("/admin/team-names")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamNameIDTO> listAllTeamNames(){
        return teamService.listAllTeamNames();
    };

    //*WORKS
    @GetMapping("/admin/one-team")
    @ResponseStatus(HttpStatus.OK)
    public TeamReadDTO getTeamById(@RequestParam("id") Long id){
        return teamService.getTeamById(id);
    };

    //* UPDATE REQUEST

    //TODO : test
    @PatchMapping("/admin/change-team")
    @ResponseStatus(HttpStatus.OK)
    public void updateTeam(@RequestParam("id") Long id, @RequestBody TeamTransactionDTO inputs){
        teamService.updateTeam(id, inputs);
    };

    //* DELETE REQUEST

    //*WORKS
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTeam(@RequestParam("id") Long id){
        teamService.deleteTeam(id);
    };
};
