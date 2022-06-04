package com.nandaparbat.SaasSportClubAPI.repositories;


import com.nandaparbat.SaasSportClubAPI.DTOs.TournamentCardView;
import com.nandaparbat.SaasSportClubAPI.DTOs.TournamentView;


import com.nandaparbat.SaasSportClubAPI.DTOs.TournamentViewCard;
import com.nandaparbat.SaasSportClubAPI.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    //* ---- GET REQUESTS ------


    //* WORKS => DTO
    @Query("SELECT new com.nandaparbat.SaasSportClubAPI.DTOs.TournamentViewCard(t.id, t.name, t.format.name, t" +
            ".pairingStyle.name, t.firstPrice, t.registerFeeSenior, t.registerFeeJunior, t.description) " +
            "FROM Tournament t WHERE t.event = TRUE")
    List<TournamentViewCard> findAllByEventIsTrue();

//    List<TournamentCardView> findAllByEventIsTrue();

    //* WORKS => DTO
    @Query("SELECT new com.nandaparbat.SaasSportClubAPI.DTOs.TournamentView(t.id, t.name, t.event, t.dateOfStart, t" +
            ".dateOfEnd, t.numberOfRounds, t.format.name, t.pairingStyle.name, t.organisator, t.contact, t" +
            ".capacity, t" +
            ".firstPrice, t.secondPrice, t.thirdPrice, t.registerFeeSenior, t.registerFeeJunior, t.description) " +
            "FROM Tournament t WHERE t.id = ?1")
    TournamentView findWithId(Long id);

    //* WORKS => DTO
    <Type> List<Type> findAllProjectedBy(Class<Type> type);

    //* WORKS => DTO
    @Query("SELECT new com.nandaparbat.SaasSportClubAPI.DTOs.TournamentViewCard(t.id, t.name, t.format.name,t" +
            ".pairingStyle.name, t.firstPrice, t.registerFeeSenior, t.registerFeeJunior, t.description) " +
            "FROM Tournament t WHERE LOWER(t.contact) " +
            "LIKE LOWER(CONCAT('%',?1,'%')) ")
    List<TournamentViewCard> findAllByContactContains(String contact);

    //* WORKS => DTO
    @Query("SELECT new com.nandaparbat.SaasSportClubAPI.DTOs.TournamentViewCard(t.id, t.name, t.format.name,t" +
            ".pairingStyle.name, t.firstPrice, t.registerFeeSenior, t.registerFeeJunior, t.description) "  +
            "FROM Tournament t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%',?1,'%')) ")
    List<TournamentViewCard> findAllByNameIsContaining(String tourName);

    //* WORKS => DTO
    @Query("SELECT new com.nandaparbat.SaasSportClubAPI.DTOs.TournamentViewCard(t.id, t.name, t.format.name,t" +
            ".pairingStyle.name, t.firstPrice, t.registerFeeSenior, t.registerFeeJunior, t.description) "  +
            "FROM Tournament t WHERE LOWER(t.format.name) LIKE LOWER(CONCAT('%',:formatName,'%'))")
    List<TournamentViewCard> findAllByFormatContains(@Param("formatName") String formatName);

    //* WORKS => DTO
    //? Refator for String format and Pairing ?
    List<TournamentCardView> findAllByIdIsBetween(Long x, Long y);

    //* ---- DELETE REQUESTS ✅

    //* WORKS
    void deleteById(Long id);
    //? Void != void

    //* ------ PATCH REQUESTS : DONE IN SERVICE IMPL ✅
    //! 1 does not exist
    //! to re-check
    @Query("SELECT t FROM Tournament t WHERE t.name = ?1")
    Optional<Tournament> findTournamentByName(String name);

    //TODO : test -> findByName


    //! ------------- CHECK LINE ---------------



    //* --- PUT REQUEST
    //* ---- POST REQUEST
};
