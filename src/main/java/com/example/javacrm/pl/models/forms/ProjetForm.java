package com.example.javacrm.pl.models.forms;

import com.example.javacrm.dal.entities.Utilisateur;
import com.example.javacrm.dal.enums.StatutProjet;
import com.example.javacrm.pl.models.DTOs.UtilisateurProjetDTO;

import java.time.LocalDate;
import java.util.List;

public record ProjetForm(
        String theme,
        String commentaire,
        LocalDate dateCreation,
        LocalDate dateModification,
        LocalDate deadline,
        StatutProjet statut,
        List<Utilisateur> utilisateurs
) {
}
