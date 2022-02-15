package fr.sorbonne.paris.nord.university.api.controller;
import java.util.List;
import java.util.Optional;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public List<PlayerDTO> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/get/{id}")
    public Optional<PlayerDTO> getPlayerById(@PathVariable("id") Long playerId){
        return playerService.getPlayerById(playerId);
    }

    @PostMapping("/add")
    public void addPlayer(PlayerDTO player) {
        playerService.addPlayer(player);
    }

    @PutMapping("/update")
    public void updatePlayer(PlayerDTO player) {
        playerService.updatePlayer(player);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeamById(@PathVariable("id") Long playerId) {
        playerService.deletePlayerById(playerId);
    }
}
