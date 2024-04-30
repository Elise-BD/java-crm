package com.example.javacrm.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference")
    private String reference = "U-"+id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "fonction")
    private String fonction;

    //TODO retourner une copie de la liste dans le getter
    @Setter
    @OneToMany(mappedBy = "utilisateur", orphanRemoval = true)
    private List<Tache> taches = new ArrayList<>();

}
