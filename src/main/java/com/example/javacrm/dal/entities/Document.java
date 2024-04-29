package com.example.javacrm.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    private Integer id;

    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "date_modification")
    private LocalDate dateModification;

    // la liste des id clients suffirait
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_client", nullable = false, unique = true)
    private Client idClient;

    @ManyToMany(mappedBy = "documents")
    private List<Article> articles = new ArrayList<>();

    @Column(name = "montant")
    private Float montant;
}
