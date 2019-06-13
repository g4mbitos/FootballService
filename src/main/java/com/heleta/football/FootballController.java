package com.heleta.football;


import com.heleta.football.data.FootballService;
import com.heleta.football.enteties.Player;
import com.heleta.football.enteties.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/football")
public class FootballController {

    @Autowired
    FootballService service;

    //work
    @GetMapping("/players")
    public List<Player> getAllPlayers() {

        return service.getAllPlayers();
    }

    //work
    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable Long id) {

        return service.getPlayer(id);
    }

    //work
    @GetMapping("/players/{teamName}")
    public List<Player> getPlayersByTeam(@PathVariable String teamName) {

        return service.getPlayersByTeamName(teamName);
    }

    //work
    @PostMapping("/player")
    public Player addPlayer(@RequestBody Player player) {

        return service.addPlayer(player);
    }

    //work
    @PutMapping("/player/{id}")
    public Player updatePlayer(@RequestBody Player player, @PathVariable Long id) {

        return service.updatePlayer(player, id);
    }

    //work
    @PutMapping("/player")
    public Player updatePlayer(@RequestBody Player player) {

        return service.updatePlayer(player);
    }

    //work
    @DeleteMapping("/player/{id}")
    public void deletePlayer(@PathVariable Long id) {

        service.deletePlayer(id);
    }

    //work
    @GetMapping("/team/{id}")
    public Team getTeam(@PathVariable Long id) {

        return service.getTeam(id);
    }

    //work
    @GetMapping("/teams/{name}")
    public Team getTeamByName(@PathVariable String name) {

        return service.getTeamByName(name);
    }

    //work
    @GetMapping("/teams")
    public List<Team> getAllTeams() {

        return service.getAllTeams();
    }

    //work
    @PostMapping("/team")
    public Team addTeam(@RequestBody Team team) {

        return service.addTeam(team);
    }

    //work
    @PutMapping("/team/{id}")
    public Team updateTeam(@RequestBody Team team, @PathVariable Long id) {

        return service.updateTeam(team, id);
    }

    //work
    @PutMapping("/team")
    public Team updateTeam(@RequestBody Team team) {

        return service.updateTeam(team);
    }

    //work
    @DeleteMapping("/team/{id}")
    public void deleteTeam(@PathVariable Long id) {

        service.deleteTeam(id);
    }

    //work
    @GetMapping("/captain/{teamName}")
    public Player getCaptain(@PathVariable String teamName) {

        return service.getCaptainByTeamName(teamName);
    }

    //work
    @PutMapping("/team/{idTeam}/player/{idPlayer}")
    public Player addPlayerToTeam(@PathVariable Long idTeam, @PathVariable Long idPlayer) {

        return service.addPlayerToTeam(idPlayer, idTeam);
    }

    //work
    @DeleteMapping("team/player/{id}")
    public Player deletePlayerFromTeam(@PathVariable Long id) {

        return service.deletePlayerFromTeam(id);
    }

    //work
    @PostMapping("/team/{id}/player")
    public Player addNewPlayerInTeam(@RequestBody Player player, @PathVariable Long id) {

        return service.addNewPlayerToTeam(player, id);
    }

    //work
    @PutMapping("/team/{idTeam}/captain/{idCaptain}")
    public Player assignCaptain(@PathVariable Long idTeam, @PathVariable Long idCaptain) {

        return service.assignCaptain(idCaptain, idTeam);
    }

}
