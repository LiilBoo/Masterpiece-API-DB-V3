package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.*;
import com.nandaparbat.SaasSportClubAPI.entities.Format;
import com.nandaparbat.SaasSportClubAPI.entities.PairingStyle;
import com.nandaparbat.SaasSportClubAPI.entities.Tournament;
import com.nandaparbat.SaasSportClubAPI.repositories.FormatRepository;
import com.nandaparbat.SaasSportClubAPI.repositories.PairingStyleRepository;
import com.nandaparbat.SaasSportClubAPI.repositories.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;

    private final FormatRepository formatRepository;

    private final PairingStyleRepository pairingStyleRepository;


    //* ---- GET REQUESTS

    //* WORKS => DTO
    @Override
    public List<TournamentCardView> findAllToursCards() {
        return tournamentRepository.findAllProjectedBy(TournamentCardView.class);
    }

    @Override
    public List<TournamentNameView> listAdminTournaments() {
        return tournamentRepository.listAdminTournaments();
    };


    //* WORKS 100% //Returns a DTO
    @Override
    public TournamentView findWithId(Long id) {
        return tournamentRepository.findWithId(id);
    };

    //* WORKS => DTO
    @Override
    public List<TournamentViewCard> findAllByEventIsTrue() {
        return tournamentRepository.findAllByEventIsTrue();
    };

    //* WORKS => DTO
    @Override
    public List<TournamentViewCard> findAllByNameIsContaining(String tourName){
        return tournamentRepository.findAllByNameIsContaining(tourName);
    };

    //* WORKS => DTO
    @Override
    public List<TournamentViewCard> findAllByContactContains(String contact) {
        return tournamentRepository.findAllByContactContains(contact);
    };

    //* WORKS => DTO
    @Override
    public List<TournamentViewCard> findAllByFormatContains(String formatName) {
        return tournamentRepository.findAllByFormatContains(formatName);
    };

    //* WORKS => DTO
    @Override
    public List<TournamentCardView> paginatePer10(Long x) {

        //* Starts at 0
        x = x * 10;

        Long y = x + 10;

        return tournamentRepository.findAllByIdIsBetween(x,y);
    };


    //* -------- PATCH REQUEST --------

    //*Helper Method to update
    public Tournament tournamentUpdate(TournamentPatch inputs, Long id){

        Tournament tour = tournamentRepository.getById(id);


        if((inputs.getName() != null) &&
                (!inputs.getName().isEmpty()) &&
                (!Objects.equals(tour.getName(), inputs.getName()))){
            Optional<Tournament> optionalTournament = tournamentRepository.findTournamentByName(inputs.getName());
            if(optionalTournament.isPresent()){
                throw new IllegalStateException("Name taken");
            };
            tour.setName(inputs.getName());
        };

        if((inputs.getEvent() != null) &&
                (!Objects.equals(tour.isEvent(), inputs.getEvent()))){
            tour.setEvent(inputs.getEvent());
        };

        if((inputs.getDateOfStart() != null) &&
                (!Objects.equals(tour.getDateOfStart(), inputs.getDateOfStart()))){
            tour.setDateOfStart(inputs.getDateOfStart());
        };

        if((inputs.getDateOfEnd() != null) &&
                (!Objects.equals(tour.getDateOfEnd(), inputs.getDateOfEnd()))){
            tour.setDateOfEnd(inputs.getDateOfEnd());
        };

        if((inputs.getNumberOfRounds() != null) &&
                (inputs.getNumberOfRounds() != 0) &&
                (!Objects.equals(tour.getNumberOfRounds(), inputs.getNumberOfRounds()))){
            tour.setNumberOfRounds(inputs.getNumberOfRounds());
        };

        if((inputs.getFormatId() != null) ){
            //TODO : Verify it's an exisiting Format in Database

            Format format = formatRepository.findById(inputs.getFormatId()).get();

            tour.setFormat(format);
        };

        if(inputs.getPairingId() != null){
            //TODO : Verify it's an exisiting PairingStyle in Database
            PairingStyle pairing = pairingStyleRepository.findById(inputs.getPairingId()).get();
            tour.setPairingStyle(pairing);
        };

        if((inputs.getOrganisator() != null) &&
                (!inputs.getOrganisator().equals("")) &&
                        (!Objects.equals(tour.getOrganisator(), inputs.getOrganisator()))){
            tour.setOrganisator(inputs.getOrganisator());
        };

        if((inputs.getContact() != null) &&
                (!inputs.getContact().isEmpty()) &&
                    (!Objects.equals(tour.getContact(), inputs.getContact()))){
            tour.setContact(inputs.getContact());
        };

        if((inputs.getCapacity() != null) &&
                (inputs.getCapacity() != 0) &&
                    (!Objects.equals(tour.getCapacity(), inputs.getCapacity()))){
            tour.setCapacity(inputs.getCapacity());
        };

        if((inputs.getFirstPrice() != null) &&
                (!Objects.equals(tour.getFirstPrice(), inputs.getFirstPrice()))){
            tour.setFirstPrice(inputs.getFirstPrice());
        };

        if((inputs.getSecondPrice() != null) &&
                (!Objects.equals(tour.getSecondPrice(), inputs.getSecondPrice()))){
            tour.setSecondPrice(inputs.getSecondPrice());
        };

        if((inputs.getThirdPrice() != null) &&
                (!Objects.equals(tour.getThirdPrice(), inputs.getThirdPrice()))){
            tour.setThirdPrice(inputs.getThirdPrice());
        };

        if((inputs.getRegisterFeeJunior() != null) &&
                (!Objects.equals(tour.getRegisterFeeJunior(), inputs.getRegisterFeeJunior()))){
            tour.setRegisterFeeJunior(inputs.getRegisterFeeJunior());
        };

        if((inputs.getRegisterFeeSenior() != null) &&
                (!Objects.equals(tour.getRegisterFeeSenior(), inputs.getRegisterFeeSenior()))){
            tour.setRegisterFeeSenior(inputs.getRegisterFeeSenior());
        };

        if((inputs.getDescription() != null) &&
                (!inputs.getDescription().isEmpty()) &&
                    (!Objects.equals(tour.getDescription(), inputs.getDescription()))){
            tour.setDescription(inputs.getDescription());
        };

        return tour;

    };

    //! javax Transactional;
    // ! not spring annotation transactional
    @Override
    @Transactional
    public void update1Tournament(TournamentPatch inputs, Long id) {

        Tournament tour = this.tournamentUpdate(inputs, id);

        tournamentRepository.save(tour);

    };

    //* --- POST REQUEST : CREATE

    //* WORKS
    //? Did work : test more
    @Transactional
    public Tournament tournamentSetting(@Nullable TournamentCreate inputs){
        Tournament tournament = new Tournament();
        //-- tournament : tournament name
        tournament.setName(inputs.getName());

        //-- tournament : date of start
        tournament.setDateOfStart(inputs.getDateOfStart());
        //-- tournament : date of end
        tournament.setDateOfEnd(inputs.getDateOfEnd());
        //-- tournament : number of rounds
        tournament.setNumberOfRounds(inputs.getNumberOfRounds());
        //-- tournament : cadence format
        Format format = formatRepository.findById(inputs.getFormatId()).get();
        tournament.setFormat(format);
        //-- tournamenet : pairing Style

        PairingStyle pairing = pairingStyleRepository.findById(inputs.getPairingId()).get();
//        Long number = new Long(1);
//        PairingStyle pairing = new PairingStyle(number, "Suisse");
        tournament.setPairingStyle(pairing);
        //-- tournament : organisator
        tournament.setOrganisator(inputs.getOrganisator());
        //-- tournament : contact
        tournament.setContact(inputs.getContact());
        //-- tournament : capacity
        tournament.setCapacity(inputs.getCapacity());
        //-- tournament : first Price
        tournament.setFirstPrice(inputs.getFirstPrice());
        //-- tournament : second Price
        tournament.setSecondPrice(inputs.getSecondPrice());
        //-- tournamenent : thrid Price
        tournament.setThirdPrice(inputs.getThirdPrice());
        //-- tournament : register fee Junior
        tournament.setRegisterFeeJunior(inputs.getRegisterFeeJunior());
        //-- tournament : register fee Senior
        tournament.setRegisterFeeSenior(inputs.getRegisterFeeSenior());
        //- tournament : description
        tournament.setDescription(inputs.getDescription());

        return tournament;
    };

    //? More tests to do
    @Override
    @Transactional
    public void tournamentCreate(TournamentCreate inputs) {
        Tournament tournament = this.tournamentSetting(inputs);
        tournamentRepository.save(tournament);
    };

    //* -------- DELETE REQUEST -------

    //* WORKS => HTTP 200
    @Override
    public void deleteWithId(Long id) {

        TournamentView tour = tournamentRepository.findWithId(id);

        tournamentRepository.deleteById(tour.getId());
    };


    //! ---------- CHECK LINE : CODE ABOVE WORKS --------------

    //! USELESS DOES NOT WORK
    @Override
    @Transactional
    public void overrideTournament(TournamentPatch inputs, Long id) {

        Tournament tour = tournamentRepository.findById(id).get();

        tour.setName(inputs.getName());
        tour.setEvent(inputs.getEvent());

            tour.setDateOfStart(inputs.getDateOfStart());

            tour.setDateOfEnd(inputs.getDateOfEnd());

            tour.setNumberOfRounds(inputs.getNumberOfRounds());

            //TODO : Verify it's an exisiting Format in Database
        Format format = formatRepository.findById(inputs.getFormatId()).get();
        tour.setFormat(format);

            //TODO : Verify it's an exisiting PairingStyle in Database
        PairingStyle pairing = pairingStyleRepository.findById(inputs.getPairingId()).get();
        tour.setPairingStyle(pairing);

            tour.setOrganisator(inputs.getOrganisator());

            tour.setContact(inputs.getContact());

            tour.setCapacity(inputs.getCapacity());

            tour.setFirstPrice(inputs.getFirstPrice());

            tour.setSecondPrice(inputs.getSecondPrice());

            tour.setThirdPrice(inputs.getThirdPrice());

            tour.setRegisterFeeJunior(inputs.getRegisterFeeJunior());

            tour.setRegisterFeeSenior(inputs.getRegisterFeeSenior());

            tour.setDescription(inputs.getDescription());

            tournamentRepository.save(tour);

    };



};
