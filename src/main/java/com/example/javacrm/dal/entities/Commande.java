package com.example.javacrm.dal.entities;

import com.example.javacrm.dal.enums.StatutCommande;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Commande extends Document {

    @Column(name = "reference")
    private String reference = "CD-"+getId();

    @Column(name = "statut")
    StatutCommande statut;


}
