package com.example.javacrm.dal.entities;

import com.example.javacrm.dal.enums.StatutProjet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Setter
    @Column(name = "theme", nullable = false)
    private String theme;

    @Setter
    @Column(name = "commentaire")
    private String commentaire;

    @Setter
    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @Setter
    @Column(name = "date_modification")
    private LocalDate dateModification;

    @Setter
    @Column(name = "deadline")
    private LocalDate deadline;

    @Setter
    @Column(name = "statut")
    StatutProjet statut;

    //TODO retourner une copie de la liste dans le getter
    @Setter
    @ManyToMany
    @JoinTable(name = "Projet_utilisateurs",
            joinColumns = @JoinColumn(name = "projet_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateurs_id"))
    private List<Utilisateur> utilisateurs = new ArrayList<>();

}
