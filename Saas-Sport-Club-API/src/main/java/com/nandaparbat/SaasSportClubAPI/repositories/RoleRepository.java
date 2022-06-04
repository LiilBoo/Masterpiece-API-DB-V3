package com.nandaparbat.SaasSportClubAPI.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository {


    //* WORKS => DTO
    <Type> List<Type> findAllProjectedBy(Class<Type> type);



}
