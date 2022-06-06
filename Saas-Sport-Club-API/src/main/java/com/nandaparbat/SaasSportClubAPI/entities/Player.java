package com.nandaparbat.SaasSportClubAPI.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "fide_number", nullable = false)
    private int fideNumber;

    @Column(name = "elo")
    private Integer elo;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password; //VARCHAR(60)

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany
    @JoinTable(name = "players_teams",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;

    public void setElo(Integer elo) {
        this.elo = elo;
    };

    public List<Team> getTeams() {
        return teams;
    };

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    };

    public Long getId() {
        return id;
    };

    public String getFirstName() {
        return firstName;
    };

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    };

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFideNumber() {
        return fideNumber;
    }

    public void setFideNumber(int fideNumber) {
        this.fideNumber = fideNumber;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
};
