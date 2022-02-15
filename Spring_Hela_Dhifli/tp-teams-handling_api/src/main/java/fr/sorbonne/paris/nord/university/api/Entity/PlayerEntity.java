package fr.sorbonne.paris.nord.university.api.Entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name ="player")
public class PlayerEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(nullable=false)
        private String name;
        private String number;
        private String position;
        @ManyToOne
        @JoinColumn(name ="team_id", nullable = false)
        private TeamEntity team;
    }
