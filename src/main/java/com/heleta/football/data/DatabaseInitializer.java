package com.heleta.football.data;

import com.heleta.football.enteties.Player;
import com.heleta.football.enteties.Position;
import com.heleta.football.enteties.Team;
import com.heleta.football.repos.PlayerRepo;
import com.heleta.football.repos.TeamRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

@Configuration
@Slf4j
public class DatabaseInitializer {

    @Bean
    CommandLineRunner LoadDatabase(PlayerRepo playerRepo, TeamRepo teamRepo) {
        return args -> {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //Juventus

            Team team1 = new Team("Juventus");

            Player player11 = new Player("Cristiano","Ronaldo",dateFormat.parse("05/02/1985"), Position.LF);
            Player player12 = new Player("Mattia"," Perin",dateFormat.parse("10/11/1992"), Position.GK);
            Player player13 = new Player("Alex","Sandro",dateFormat.parse("26/01/1991"), Position.LB);

            //Liverpool

            Team team2 = new Team("Liverpool FC");

            Player player21 = new Player("Simon","Mignolet",dateFormat.parse("06/03/1988"), Position.GK);
            Player player22 = new Player("Jordan","Henderson",dateFormat.parse("17/06/1990"), Position.RM);
            Player player23 = new Player("Sadio","Mané",dateFormat.parse("10/04/1992"), Position.RF);

            //Manchester United

            Team team3 = new Team("Manchester United");

            Player player31 = new Player("Sergio","Romero",dateFormat.parse("22/02/1987"), Position.GK);
            Player player32 = new Player("Antonio","Valencia",dateFormat.parse("04/08/1985"), Position.LWB);
            Player player33 = new Player("James","Garner",dateFormat.parse("13/03/2001"), Position.CM);

//            System.out.println("Add player " + footballService.addPlayer(player11));
//            System.out.println("Add player " + footballService.addPlayer(player12));
//            System.out.println("Add player " + footballService.addPlayer(player13));
//
//            System.out.println("Add player " + footballService.addPlayer(player21));
//            System.out.println("Add player " + footballService.addPlayer(player22));
//            System.out.println("Add player " + footballService.addPlayer(player23));
//
//            System.out.println("Add player " + footballService.addPlayer(player31));
//            System.out.println("Add player " + footballService.addPlayer(player32));
//            System.out.println("Add player " + footballService.addPlayer(player33));
//
//            System.out.println("Add team " + footballService.addTeam(team1));
//            System.out.println("Add team " + footballService.addTeam(team2));
//            System.out.println("Add team " + footballService.addTeam(team3));


            System.out.println("Add player " + playerRepo.save(player11));
            System.out.println("Add player " + playerRepo.save(player12));
            System.out.println("Add player " + playerRepo.save(player13));
            System.out.println("Add player " + playerRepo.save(player21));
            System.out.println("Add player " + playerRepo.save(player22));
            System.out.println("Add player " + playerRepo.save(player23));
            System.out.println("Add player " + playerRepo.save(player31));
            System.out.println("Add player " + playerRepo.save(player32));
            System.out.println("Add player " + playerRepo.save(player33));

            System.out.println("Add team " + teamRepo.save(team1));
            System.out.println("Add team " + teamRepo.save(team2));
            System.out.println("Add team " + teamRepo.save(team3));

            System.out.println("Add player " + playerRepo.save(player11.setTeam(team1)).getFirstName() + " " + player11.getLastName() + " to team " + team1.getName());
            System.out.println("Add player " + playerRepo.save(player12.setTeam(team1)).getFirstName() + " " + player12.getLastName() + " to team " + team1.getName());
            System.out.println("Add player " + playerRepo.save(player13.setTeam(team1)).getFirstName() + " " + player13.getLastName() + " to team " + team1.getName());

            System.out.println("Add player " + playerRepo.save(player21.setTeam(team2)).getFirstName() + " " + player21.getLastName() + " to team " + team1.getName());
            System.out.println("Add player " + playerRepo.save(player22.setTeam(team2)).getFirstName() + " " + player22.getLastName() + " to team " + team1.getName());
            System.out.println("Add player " + playerRepo.save(player23.setTeam(team2)).getFirstName() + " " + player23.getLastName() + " to team " + team1.getName());

            System.out.println("Add player " + playerRepo.save(player31.setTeam(team3)).getFirstName() + " " + player31.getLastName() + " to team " + team1.getName());
            System.out.println("Add player " + playerRepo.save(player32.setTeam(team3)).getFirstName() + " " + player32.getLastName() + " to team " + team1.getName());
            System.out.println("Add player " + playerRepo.save(player33.setTeam(team3)).getFirstName() + " " + player33.getLastName() + " to team " + team1.getName());

            System.out.println("Add captain " +player11.getFirstName()+" "+player11.getLastName() +" to team " + teamRepo.save(team1.setCaptain(player11)).getName());
            System.out.println("Add captain " +player22.getFirstName()+" "+player22.getLastName() +" to team " + teamRepo.save(team2.setCaptain(player22)).getName());
            System.out.println("Add captain " +player31.getFirstName()+" "+player31.getLastName() +" to team " + teamRepo.save(team3.setCaptain(player31)).getName());


//            //Juventus
//            Player player11 = new Player("Cristiano","Ronaldo",dateFormat.parse("05/02/1985"), Position.LF);
//            Player player12 = new Player("Mattia"," Perin",dateFormat.parse("10/11/1992"), Position.GK);
//            Player player13 = new Player("Alex","Sandro",dateFormat.parse("26/01/1991"), Position.LB);
//
//            //Liverpool
//            Player player21 = new Player("Simon","Mignolet",dateFormat.parse("06/03/1988"), Position.GK);
//            Player player22 = new Player("Jordan","Henderson",dateFormat.parse("17/06/1990"), Position.RM);
//            Player player23 = new Player("Sadio","Mané",dateFormat.parse("10/04/1992"), Position.RF);
//
//            //Manchester United
//            Player player31 = new Player("Sergio","Romero",dateFormat.parse("22/02/1987"), Position.GK);
//            Player player32 = new Player("Antonio","Valencia",dateFormat.parse("04/08/1985"), Position.LWB);
//            Player player33 = new Player("James","Garner",dateFormat.parse("13/03/2001"), Position.CM);
//
//            //Teams
//            Team team1 = new Team("Juventus");
//            Team team2 = new Team("Liverpool FC");
//            Team team3 = new Team("Manchester United");
//
//            System.out.println("Add team "+ teamRepo.save(team1));
//            System.out.println("Add team "+ teamRepo.save(team2));
//            System.out.println("Add team "+ teamRepo.save(team3));
//
//            System.out.println("Add player "+playerRepo.save(player11.setTeam(team1)));
//            System.out.println("Add player "+playerRepo.save(player12.setTeam(team1)));
//            System.out.println("Add player "+playerRepo.save(player13.setTeam(team1)));
//
//            System.out.println("Add player "+playerRepo.save(player21.setTeam(team2)));
//            System.out.println("Add player "+playerRepo.save(player22.setTeam(team2)));
//            System.out.println("Add player "+playerRepo.save(player23.setTeam(team2)));
//
//            System.out.println("Add player "+playerRepo.save(player31.setTeam(team3)));
//            System.out.println("Add player "+playerRepo.save(player32.setTeam(team3)));
//            System.out.println("Add player "+playerRepo.save(player33.setTeam(team3)));
//
//            System.out.println("Assign captain in team"+teamRepo.save(team1.setCaptain(player11)));
//            System.out.println("Assign captain in team"+teamRepo.save(team2.setCaptain(player23)));
//            System.out.println("Assign captain in team"+teamRepo.save(team3.setCaptain(player32)));
        };
    }

}
