package fr.sorbonne.paris.nord.university.api.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="team")
	public class TeamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, unique = true)
	private String name;
	private String slogan;
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<PlayerEntity> players = new ArrayList<>();


}
