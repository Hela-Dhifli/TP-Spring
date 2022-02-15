package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public List<PlayerDTO> getAllPlayers();

    Optional<PlayerDTO> getPlayerById(Long playerId);

    void addPlayer(PlayerDTO player);

    void updatePlayer(PlayerDTO player);

    void deletePlayerById(Long id);
}
