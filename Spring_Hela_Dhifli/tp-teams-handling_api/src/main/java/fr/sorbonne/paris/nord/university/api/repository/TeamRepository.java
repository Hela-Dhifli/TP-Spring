package fr.sorbonne.paris.nord.university.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sorbonne.paris.nord.university.api.Entity.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity,Long>{

}
