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
    FootballService provider;

    //work
    @GetMapping("/players")
    List<Player> getAllPlayers() {

        return provider.getAllPlayers();
    }

    //work
    @GetMapping("/player/{id}")
    Player getPlayer(@PathVariable Long id) {

        return provider.getPlayer(id);
    }

    //work
    @GetMapping("/players/{teamName}")
    List<Player> getPlayersByTeam(@PathVariable String teamName) {

        return provider.getPlayersByTeamName(teamName);
    }

    //work
    @PostMapping("/player")
    Player addPlayer(@RequestBody Player player){

        return provider.addPlayer(player);
    }

    //work
    @PutMapping("/player/{id}")
    Player updatePlayer(@RequestBody Player player, @PathVariable Long id){

        return provider.updatePlayer(player, id);
    }

    //work
    @PutMapping("/player")
    Player updatePlayer(@RequestBody Player player){

        return provider.updatePlayer(player);
    }

    //work
    @DeleteMapping("/player/{id}")
    void deletePlayer(@PathVariable Long id){

        provider.deletePlayer(id);
    }

    //work
    @GetMapping("/team/{id}")
    Team getTeam(@PathVariable Long id) {

        return provider.getTeam(id);
    }

    //work
    @GetMapping("/teams/{name}")
    Team getTeamByName(@PathVariable String name) {

        return provider.getTeamByName(name);
    }

    //work
    @GetMapping("/teams")
    List<Team> getAllTeams() {

        return provider.getAllTeams();
    }

    //work
    @PostMapping("/team")
    Team addTeam(@RequestBody Team team){

        return provider.addTeam(team);
    }

    //work
    @PutMapping("/team/{id}")
    Team updateTeam(@RequestBody Team team,@PathVariable Long id){

        return provider.updateTeam(team, id);
    }

    //work
    @PutMapping("/team")
    Team updateTeam(@RequestBody Team team){

        return provider.updateTeam(team);
    }

    //work
    @DeleteMapping("/team/{id}")
    void deleteTeam(@PathVariable Long id){

        provider.deleteTeam(id);
    }

    //work
    @GetMapping("/captain/{teamName}")
    Player getCaptain(@PathVariable String teamName){

        return provider.getCaptainByTeamName(teamName);
    }

    //work
    @PutMapping("/team/{idTeam}/player/{idPlayer}")
    Player addPlayerToTeam(@PathVariable Long idTeam, @PathVariable Long idPlayer){

        return provider.addPlayerToTeam(idPlayer, idTeam);
    }

    //work
    @DeleteMapping("team/player/{id}")
    Player deletePlayerFromTeam(@PathVariable Long id){

        return provider.deletePlayerFromTeam(id);
    }

    //work
    @PostMapping("/team/{id}/player")
    Player addNewPlayerInTeam(@RequestBody Player player, @PathVariable Long id){

        return provider.addNewPlayerToTeam(player, id);
    }

    //work
    @PutMapping("/team/{idTeam}/captain/{idCaptain}")
    Player assignCaptain(@PathVariable Long idTeam, @PathVariable Long idCaptain){

        return provider.assignCaptain(idCaptain, idTeam);
    }

}
