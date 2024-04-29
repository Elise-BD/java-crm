package com.example.javacrm.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Prospect {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference")
    private String reference = "P-"+id;

    @Setter
    @Column(name = "societe", nullable = false)
    private String societe;

    @Setter
    @Column(name = "nom")
    private String contactNom;

    @Setter
    @Column(name = "prenom")
    private String contactPrenom;

    @Setter
    @Column(name = "fonction")
    private String contactFonction;

    @Setter
    @Column(name = "email", nullable = false)
    private String email;

    @Setter
    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Setter
    @Column(name = "pays", nullable = false)
    private String pays;

    @Setter
    @Column(name = "ville", nullable = false)
    private String ville;

    @Setter
    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    @Setter
    @Column(name = "adresse")
    private String adresse;


}
