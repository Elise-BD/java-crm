package com.example.javacrm.dal.entities;

import com.example.javacrm.dal.enums.StatutTache;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "objet", nullable = false)
    private String objet;

    @Column(name = "description")
    private String description;

    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "date_modification")
    private LocalDate dateModification;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "statut")
    StatutTache statut;

    @Setter
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

}
