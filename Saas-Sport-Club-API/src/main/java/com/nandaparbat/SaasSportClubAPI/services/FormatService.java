package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.formats.FormatDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.formats.FormatIDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface FormatService {

    //* ---- CREATE REQUEST
    void createFormat(FormatDTO inputs);

    //* --- READ REQUESTS

    //*Perfect
    List<FormatIDTO> findAllProjectedBy();

    //*Perfect
    FormatDTO findFormatById(Long id);

    //*Works
    List<FormatIDTO> findAllByNameEquals(String formatName);

    //* --- UPDATE REQUEST
    @Transactional
    void updateFormat(FormatDTO inputs, Long id);
    //* --- DELETE REQUEST
    void deleteFormat(Long id);
};
