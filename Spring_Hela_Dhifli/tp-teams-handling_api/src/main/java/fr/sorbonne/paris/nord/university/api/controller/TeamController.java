
package fr.sorbonne.paris.nord.university.api.controller;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {


    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/all")
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        return ResponseEntity.of(teamService.getTeamById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeam(@PathVariable Long id) {
        try{
            teamService.deleteTeamById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTeam(@RequestBody @Validated TeamDTO team)
    {
        teamService.addTeam(team);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTeam(@RequestBody @Validated TeamDTO team)
    {
        teamService.updateTeam(team);

    }

}
