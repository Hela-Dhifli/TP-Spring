package fr.sorbonne.paris.nord.university.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.Entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.Factory.TeamFactory;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamFactory teamFactory;

	@Override
	@Transactional(readOnly = true)
	public List<TeamDTO> getAllTeams() {

		return teamRepository.findAll().stream().map(teamFactory::toDto).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TeamDTO> getTeamById(Long teamId) {
		return teamRepository.findById(teamId).map(teamFactory::toDto);

	}


	@Override
	@Transactional
	public void addTeam(TeamDTO team) {

		teamRepository.save(teamFactory.toEntity(team));
	}

	@Override
	@Transactional
	public void updateTeam(TeamDTO team) {
		final TeamEntity entity= teamRepository.findById(team.getId()).orElseThrow(IllegalStateException::new);
		entity.setName(team.getName());
		entity.setSlogan(team.getSlogan());

	}

	@Override
	@Transactional
	public void deleteTeamById(Long id) {
		teamRepository.deleteById(id);

	}


}



