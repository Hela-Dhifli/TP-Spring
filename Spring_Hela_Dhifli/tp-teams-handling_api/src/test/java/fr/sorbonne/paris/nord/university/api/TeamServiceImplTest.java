package fr.sorbonne.paris.nord.university.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.sorbonne.paris.nord.university.api.Entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.Factory.TeamFactory;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import fr.sorbonne.paris.nord.university.api.service.TeamServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TeamServiceImplTest {

	@Mock
	private TeamRepository teamRepository;
	
	@Mock
	private TeamFactory teamFactory;
	
	@InjectMocks
	private TeamServiceImpl service;

	@Test
	void getAllTeams()
	{
		//Given
		final ArrayList<TeamEntity> teamEntites = new ArrayList<>();
		teamEntites.add(new TeamEntity());
		
		
		when(teamRepository.findAll()).thenReturn(teamEntites);
		
		doCallRealMethod().when(teamFactory).toDto(any(TeamEntity.class));
		
		//WHEN
		final List<TeamDTO> allTeams = service.getAllTeams();
		//THEN
		assertEquals(1,allTeams.size());
		
		verify(teamRepository, times(1)).findAll();
		
		
	}
	
	
	@Test
	void updateTeams() {
		//Given
		final TeamDTO teamDTO = new TeamDTO ();
		teamDTO.setId(1L);
		teamDTO.setName("Sénégal");
		teamDTO.setSlogan("Lions du sénégal");
		
		final TeamEntity entity = new TeamEntity();
		
		when(teamRepository.findById(anyLong())).thenReturn(Optional.of(entity));
		
		//WHEN
		service.updateTeam(teamDTO);
		
		//THEN
		assertEquals("Sénégal", entity.getName());
		assertEquals("Lions du sénégal", entity.getSlogan());
		
	}
	
	@Test
	void addTeam() {
		//GIVEN
		final TeamDTO teamDTO = new TeamDTO();
		
		final TeamEntity teamEntity = new TeamEntity();
		
		when(teamFactory.toEntity(any())).thenReturn(teamEntity);
		
		when(teamRepository.save(any(TeamEntity.class))).thenAnswer(i-> i.getArgument(0));
		
		//WHEN
		service.addTeam(teamDTO);
		
		//THEN
		verify(teamFactory).toEntity(teamDTO);
		verify(teamRepository).save(teamEntity);
		
		
	}


}
