package fr.sorbonne.paris.nord.university.api.Factory;

import fr.sorbonne.paris.nord.university.api.Entity.PlayerEntity;
import fr.sorbonne.paris.nord.university.api.Entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamFactory implements EntityFactory<TeamEntity, TeamDTO> {

	private PlayerFactory playerFactory;

	public TeamFactory() {
		playerFactory = new PlayerFactory();
	}


	@Override
	public TeamEntity toEntity (TeamDTO dto) {
		final TeamEntity teamEntity = new TeamEntity();
		teamEntity.setId(dto.getId());
		teamEntity.setName(dto.getName());
		teamEntity.setSlogan(dto.getSlogan());

		List<PlayerDTO> dtoPlayers = dto.getPlayers();
		List<PlayerEntity> entityPlayers = dtoPlayers.stream()
				   								     .map(playerFactory::toEntity)
													 .collect(Collectors.toList());

		teamEntity.setPlayers(entityPlayers);
		return teamEntity;
	}

	@Override
	public TeamDTO toDto(TeamEntity entity) {
		final TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(entity.getId());
		teamDTO.setName(entity.getName());
		teamDTO.setSlogan(entity.getSlogan());

		List<PlayerEntity> entityPlayers = entity.getPlayers();

		List<PlayerDTO> dtoPlayers = entityPlayers.stream()
				.map(playerFactory::toDto)
				.collect(Collectors.toList());

		teamDTO.setPlayers(dtoPlayers);
		return teamDTO;
	}

}
