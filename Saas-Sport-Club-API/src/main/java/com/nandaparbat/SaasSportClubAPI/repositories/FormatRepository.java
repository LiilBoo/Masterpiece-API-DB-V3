package com.nandaparbat.SaasSportClubAPI.repositories;

import com.nandaparbat.SaasSportClubAPI.DTOs.FormatDTO;
import com.nandaparbat.SaasSportClubAPI.entities.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {


    //* WORKS => DTO
    <Type> List<Type> findAllProjectedBy(Class<Type> type);



    List<FormatDTO> findAllByNameEquals(String formatName);

    List<FormatDTO> findAllByIdEquals(Long id);

//    boolean existsByName(String existingName);
//
//    boolean existsById(java.lang.Long id);

};
