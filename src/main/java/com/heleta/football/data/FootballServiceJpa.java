package com.heleta.football.data;

import com.heleta.football.enteties.Player;
import com.heleta.football.enteties.Position;
import com.heleta.football.enteties.Team;
import com.heleta.football.exceptions.PlayerExistException;
import com.heleta.football.exceptions.PlayerNotFoundException;
import com.heleta.football.exceptions.TeamExistException;
import com.heleta.football.exceptions.TeamNotFoundException;
import com.heleta.football.repos.PlayerRepo;
import com.heleta.football.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FootballServiceJpa implements FootballService {

    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    TeamRepo teamRepo;

    private boolean playerExist(Player player) {

        return playerRepo.findByFirstNameAndLastNameAndBirthday(player.getFirstName(), player.getLastName(), player.getBirthday()).isPresent();
    }

    private boolean playerExist(Long id) {

        return playerRepo.findById(id).isPresent();
    }

    public Player getPlayer(Long id) {

        return playerRepo
                .findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    public List<Player> getAllPlayers() {

        return playerRepo.findAll();
    }

    public List<Player> getPlayersByTeamName(String teamName) {

        return playerRepo.findByTeam_Name(teamName);
    }

    public Player addPlayer(Player newPlayer) {

        if (!PlayerVerify(newPlayer))
            throw new RuntimeException("Invalid player");

        if (playerExist(newPlayer))
            throw new PlayerExistException();

        return playerRepo.save(
                new Player(
                        newPlayer.getFirstName(),
                        newPlayer.getLastName(),
                        newPlayer.getBirthday(),
                        newPlayer.getPosition())
        );
    }

    public Player updatePlayer(Player newPlayer, Long id) {

        if (!PlayerVerify(newPlayer))
            throw new RuntimeException("Invalid player");

        if (playerExist(newPlayer) && !getPlayer(newPlayer).getId().equals(id))
            throw new PlayerExistException();

        return playerRepo.save(
                getPlayer(id)
                        .setFirstName(newPlayer.getFirstName())
                        .setLastName(newPlayer.getLastName())
                        .setBirthday(newPlayer.getBirthday())
                        .setPosition(newPlayer.getPosition()));
    }

    public Player updatePlayer(Player player) {

        return updatePlayer(player, player.getId());
    }

    public void deletePlayer(Long id) {

        if (!playerExist(id))
            throw new PlayerNotFoundException(id);

        Team team = teamRepo.findByCaptain_Id(id);
        if (team != null){
            playerRepo.save(getPlayer(id).setTeam(null));
            assignDefaultCaptain(team.getId());
        }

        playerRepo.deleteById(id);
    }

    public List<Player> getPlayersByFirstName(String firstName) {

        return playerRepo.findByFirstName(firstName);
    }

    public List<Player> getPlayersByLastName(String lastName) {

        return playerRepo.findByLastName(lastName);
    }

    public List<Player> getPlayersByFirstNameAndLastName(String firstName, String lastName) {

        return playerRepo.findByFirstNameAndLastName(firstName, lastName);
    }

    private Player getPlayer(Player player) {

        return playerRepo
                .findByFirstNameAndLastNameAndBirthday(player.getFirstName(), player.getLastName(), player.getBirthday())
                .orElseThrow(PlayerNotFoundException::new);
    }

    public List<Player> getPlayersByBirth(Date birthday) {

        return playerRepo.findByBirthday(birthday);
    }

    public List<Player> getPlayersByPosition(Position position) {

        return playerRepo.findByPosition(position);
    }

    private boolean teamExist(String name) {

        return teamRepo.findByName(name).isPresent();
    }

    private boolean teamExist(Long id) {

        return teamRepo.findById(id).isPresent();
    }

    public Team getTeam(Long id) {

        return teamRepo
                .findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }

    public Team getTeamByName(String name) {

        return teamRepo
                .findByName(name)
                .orElseThrow(() -> new TeamNotFoundException(name));
    }

    public List<Team> getAllTeams() {

        return teamRepo.findAll();
    }

    public Team addTeam(Team newTeam) {

        if (teamExist(newTeam.getName()))
            throw new TeamExistException(newTeam.getName());

        return teamRepo.save(
                new Team(newTeam.getName())
        );
    }

    public Team updateTeam(Team newTeam, Long id) {

        if (teamExist(newTeam.getName()) && !getTeamByName(newTeam.getName()).getId().equals(id))
            throw new TeamExistException(newTeam.getName());

        return teamRepo.save(
                getTeam(id)
                        .setName(newTeam.getName())
        );
    }

    public Team updateTeam(Team newTeam) {
        return updateTeam(newTeam, newTeam.getId());
    }

    public void deleteTeam(Long id) {

        if (!teamExist(id))
            throw new TeamNotFoundException(id);

        for (Player player:getTeam(id).getPlayers()
             ) {
            player.setTeam(null);
            playerRepo.save(player);
        }

        teamRepo.deleteById(id);
    }

    public Player getCaptainByTeamName(String name) {

        return getTeamByName(name).getCaptain();
    }

    public Player addPlayerToTeam(Long idPlayer, Long idTeam) {

        Player player = getPlayer(idPlayer);
        Team newTeam = getTeam(idTeam);
        Team oldTeam = player.getTeam();

        playerRepo.save(player.setTeam(newTeam));

        if (oldTeam != null && oldTeam.getCaptain().getId().equals(idPlayer)) {
            assignDefaultCaptain(oldTeam.getId());
        }

        if (newTeam.getPlayers().size() == 1) {
            newTeam.setCaptain(player);
            teamRepo.save(newTeam);
        }

        return player;
    }

    public Player deletePlayerFromTeam(Long idPlayer) {

        Player player = getPlayer(idPlayer);
        if (player.getTeam() == null)
            throw new RuntimeException("Player is not in any team");

        Team team = player.getTeam();

        playerRepo.save(player.setTeam(null));

        if (team.getCaptain() != null && team.getCaptain().getId().equals(idPlayer))
            assignDefaultCaptain(team.getId());

        return player;
    }

    public Player addNewPlayerToTeam(Player newPlayer, Long idTeam) {

        if (!PlayerVerify(newPlayer))
            throw new RuntimeException("Invalid player");

        if (playerExist(newPlayer))
            throw new PlayerExistException();

        return teamRepo.findById(idTeam)
                .map(team -> playerRepo.save(addPlayer(newPlayer).setTeam(team)))
                .orElseThrow(() -> new TeamNotFoundException(idTeam));
    }

    public Player assignCaptain(Long idCaptain, Long idTeam) {

        Team team = getTeam(idTeam);
        Player player = getPlayer(idCaptain);

        if (player.getTeam() != null && !player.getTeam().getId().equals(idTeam))
            addPlayerToTeam(idCaptain, idTeam);

        teamRepo.save(team.setCaptain(player));

        return player;
    }

    private void assignDefaultCaptain(Long idTeam) {

        Team team = getTeam(idTeam);
        Player freePlayer = team.getPlayers().stream()
                .findFirst()
                .orElse(null);

        team.setCaptain(freePlayer);
        teamRepo.save(team);
    }

    private boolean PlayerVerify(Player player) {

        return player != null &&
                player.getFirstName() != null &&
                player.getLastName() != null &&
                player.getBirthday() != null &&
                player.getPosition() != null;

    }
}