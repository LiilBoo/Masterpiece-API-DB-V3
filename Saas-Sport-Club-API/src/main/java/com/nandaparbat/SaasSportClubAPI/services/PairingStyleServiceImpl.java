package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.pairing.PairingStyleDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.pairing.PairingStyleIDTO;
import com.nandaparbat.SaasSportClubAPI.entities.PairingStyle;
import com.nandaparbat.SaasSportClubAPI.repositories.PairingStyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PairingStyleServiceImpl implements PairingStyleService{

    private final PairingStyleRepository pairingStyleRepository;

    //* -------- CREATE REQUEST

    //*WORKS
    @Override
    public void createPairingStyle(PairingStyleDTO inputs) {

        PairingStyle pairingStyle = new PairingStyle();

        pairingStyle.setName(inputs.getName());

        pairingStyleRepository.save(pairingStyle);
    };

    //* --------- READ REQUESTS

    //*Perfect
    @Override
    public PairingStyleDTO findPairingStyleById(Long id) {
        PairingStyle pairingStyle = pairingStyleRepository.getById(id);

        PairingStyleDTO pairingStyleDTO = new PairingStyleDTO();

        pairingStyleDTO.setName(pairingStyle.getName());

        return pairingStyleDTO;
    };

    //*WORKS
    @Override
    public List<PairingStyleIDTO> listOfPairings() {
        return pairingStyleRepository.findAllProjectedBy(PairingStyleIDTO.class);
    };

    //* ---- UPDATE REQUEST

    //*WORKS
    @Override
    public void updatePairingStyle(PairingStyleDTO inputs, Long id) {

        PairingStyle pairingStyle = pairingStyleRepository.getById(id);



        if((inputs.getName() != null) &&
                (!inputs.getName().isEmpty()) &&
                (!Objects.equals(pairingStyle.getName(), inputs.getName()))){
            pairingStyle.setName(inputs.getName());
        };

        pairingStyleRepository.save(pairingStyle);

    };

    //* ---- DELETE REQUEST
    //*WORKS
    @Override
    public void deletePairingStyle(Long id) {

    pairingStyleRepository.deleteById(pairingStyleRepository.getById(id).getId());

    };
};
