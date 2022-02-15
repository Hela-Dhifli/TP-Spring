package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.Entity.PlayerEntity;
import fr.sorbonne.paris.nord.university.api.Factory.PlayerFactory;
import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl  implements PlayerService{

    @Autowired
    private PlayerFactory playerFactory;
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream().map(playerFactory::toDto).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public Optional<PlayerDTO> getPlayerById(Long playerId) {
        return playerRepository.findById(playerId).map(playerFactory::toDto);
    }

    @Override
    public void addPlayer(PlayerDTO player) {
        playerRepository.save(playerFactory.toEntity(player));
    }

    @Override
    public void updatePlayer(PlayerDTO player) {
        final PlayerEntity entity= playerRepository.findById(player.getId()).orElseThrow(IllegalStateException::new);
        entity.setName(player.getName());
        entity.setNumber(player.getNumber());
        entity.setPosition(player.getPosition());
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
