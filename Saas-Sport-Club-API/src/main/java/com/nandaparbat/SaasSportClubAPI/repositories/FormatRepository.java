package com.nandaparbat.SaasSportClubAPI.repositories;

import com.nandaparbat.SaasSportClubAPI.DTOs.formats.FormatIDTO;
import com.nandaparbat.SaasSportClubAPI.entities.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {


    //* WORKS => DTO
    <Type> List<Type> findAllProjectedBy(Class<Type> type);



    List<FormatIDTO> findAllByNameEquals(String formatName);

    List<FormatIDTO> findAllByIdEquals(Long id);

    Format findByName(String name);

    boolean existsByName(String name);

};
