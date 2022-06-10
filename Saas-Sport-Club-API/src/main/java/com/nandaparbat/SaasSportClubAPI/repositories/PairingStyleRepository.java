package com.nandaparbat.SaasSportClubAPI.repositories;

import com.nandaparbat.SaasSportClubAPI.entities.PairingStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PairingStyleRepository extends JpaRepository<PairingStyle, Long> {


    //*READ REQUESTS

    //* WORKS => DTO
    <Type> List<Type> findAllProjectedBy(Class<Type> type);

};
