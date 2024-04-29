package com.example.javacrm.dal.entities;

import com.example.javacrm.dal.enums.StatutDevis;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference")
    private String reference = "D-"+id;

    @Column(name = "statut")
    StatutDevis statut;

    @Column(name = "delai_validite")
    @Value("60")
    private Integer delaiValidite; // nb de jours

}
