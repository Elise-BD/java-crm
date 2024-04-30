package com.example.javacrm.pl.models.forms;

import com.example.javacrm.dal.entities.Utilisateur;
import com.example.javacrm.dal.enums.StatutTache;

import java.time.LocalDate;

public record TacheForm(
        String objet,
        String description,
        LocalDate dateCreation,
        LocalDate deadline,
        StatutTache statut,
        Utilisateur utilisateur
) {
}
