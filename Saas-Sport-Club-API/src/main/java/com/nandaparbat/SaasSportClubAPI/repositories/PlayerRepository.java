package com.nandaparbat.SaasSportClubAPI.repositories;

import com.nandaparbat.SaasSportClubAPI.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //*READ REQUESTS

    Optional<Player> findByUsernameIgnoreCase(String username);

    //* WORKS => DTO
    <Type> List<Type> findAllProjectedBy(Class<Type> type);

    //* ---------

    @Transactional
    @Modifying
    @Query(value =
    "INSERT INTO tournaments_players VALUES ((SELECT t.id FROM tournaments t WHERE t.id = :tourId)," +
    "(SELECT p.id FROM players p WHERE p.id = :myPersonalId))",
            nativeQuery = true)
   void registerToTournament(@Param("tourId") Long tourId, @Param("myPersonalId") Long playerId);


    @Transactional
    @Modifying
    @Query(value= " DELETE FROM tournaments_players WHERE tournament_id = :tourId AND player_id = :myPersonalId ",
            nativeQuery = true)
    void unregisterToTournament(@Param("tourId") Long tourId, @Param("myPersonalId") Long playerId);

};
