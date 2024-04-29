package com.example.javacrm.dal.entities;

import com.example.javacrm.dal.enums.StatutFacture;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference")
    private String reference = "F-"+id;

    @Column(name = "statut")
    StatutFacture statut;

    @Column(name = "delai_paiement")
    @Value("30")
    private Integer delaiPaiement; // nb de jours


}
