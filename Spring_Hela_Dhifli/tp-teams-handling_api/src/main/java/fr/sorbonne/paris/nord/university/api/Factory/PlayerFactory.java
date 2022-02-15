package fr.sorbonne.paris.nord.university.api.Factory;

import fr.sorbonne.paris.nord.university.api.Entity.PlayerEntity;
import fr.sorbonne.paris.nord.university.api.Entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;

@Component
public class PlayerFactory implements EntityFactory<PlayerEntity, PlayerDTO>{
    @Override
    public PlayerEntity toEntity(PlayerDTO dto) {
        final PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(dto.getId());
        playerEntity.setName(dto.getName());
        playerEntity.setNumber(dto.getNumber());
        playerEntity.setPosition((dto.getPosition()));
        return playerEntity;
    }

    @Override
    public PlayerDTO toDto(PlayerEntity entity) {
        final PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(entity.getId());
        playerDTO.setName(entity.getName());
        playerDTO.setNumber(entity.getNumber());
        playerDTO.setPosition((entity.getPosition()));
        return playerDTO;
    }
}
