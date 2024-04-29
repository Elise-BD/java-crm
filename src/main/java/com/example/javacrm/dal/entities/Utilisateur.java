package com.example.javacrm.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference")
    private String reference = "U-"+id;
}
