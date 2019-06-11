package com.heleta.football.data;

import com.heleta.football.enteties.Player;
import com.heleta.football.enteties.Position;
import com.heleta.football.enteties.Team;

import java.util.Date;
import java.util.List;

public interface FootballService {

    List<Player> getAllPlayers();                               //additional

    Player getPlayer(Long id);

    List<Player> getPlayersByTeamName(String teamName);         //additional

    Player addPlayer(Player player);

    Player updatePlayer(Player player, Long id);

    Player updatePlayer(Player player);

    void deletePlayer(Long id);

    List<Player> getPlayersByFirstName(String firstName);

    List<Player> getPlayersByLastName(String lastName);

    List<Player> getPlayersByFirstNameAndLastName(String firstName, String lastname);

    List<Player> getPlayersByBirth(Date birthday);

    List<Player> getPlayersByPosition(Position position);

    Team getTeam(Long id);

    Team getTeamByName(String name);

    List<Team> getAllTeams();                                   //additional

    Team addTeam(Team team);

    Team updateTeam(Team newTeam, Long id);

    Team updateTeam(Team newTeam);

    void deleteTeam(Long id);

    Player getCaptainByTeamName(String name);                   //additional

    Player addPlayerToTeam(Long idPlayer, Long idTeam);         //additional

    Player deletePlayerFromTeam(Long idPlayer);

    Player addNewPlayerToTeam(Player player, Long idTeam);      //additional

    Player assignCaptain(Long idCaptain, Long idTeam);            //additional
}
