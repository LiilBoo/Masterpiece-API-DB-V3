package com.nandaparbat.SaasSportClubAPI.services;


import com.nandaparbat.SaasSportClubAPI.DTOs.formats.FormatDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.formats.FormatIDTO;
import com.nandaparbat.SaasSportClubAPI.entities.Format;
import com.nandaparbat.SaasSportClubAPI.repositories.FormatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FormatServiceImpl implements FormatService{

    private final FormatRepository formatRepository;

    //* --------- CREATE REQUEST
    //*WORKS
    @Override
    @Transactional
    public void createFormat(FormatDTO inputs) {

        Format format = new Format();

        format.setName(inputs.getName());

        formatRepository.save(format);
    };

    //* ------- READ REQUESTS


    //* WORKS => DTO
    @Override
    public List<FormatIDTO> findAllProjectedBy() {
        return formatRepository.findAllProjectedBy(FormatIDTO.class);
    };

    //* WORKS => DTO
    @Override
    public FormatDTO findFormatById(Long id) {

        Format format = formatRepository.getById(id);

        FormatDTO returnedFormat = new FormatDTO();

        returnedFormat.setName(format.getName());

        return returnedFormat;
    };

    //*WORKS
    //TODO : Case sensitivity
    @Override
    public List<FormatIDTO> findAllByNameEquals(String formatName) {

        return formatRepository.findAllByNameEquals(formatName);
    };

    //* UPDATE : PATCH REQUEST

    @Override
    @Transactional
    public void updateFormat(FormatDTO inputs, Long id) {

        Format format = formatRepository.findById(id).get();

        if((inputs.getName() != null) &&
                (!inputs.getName().isEmpty()) &&
                (!Objects.equals(format.getName(), inputs.getName()))){
            boolean optionalFormat = formatRepository.existsByName(inputs.getName());
            if(optionalFormat){
                throw new IllegalStateException("Name taken");
            };
            format.setName(inputs.getName());
        };
    };


   //* --------- DELETE REQUEST

    //* WORKS
    @Override
    public void deleteFormat(Long id) {

        Format format = formatRepository.getById(id);

        formatRepository.deleteById(format.getId());

    };

};
