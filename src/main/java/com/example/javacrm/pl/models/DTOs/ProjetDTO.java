package com.example.javacrm.pl.models.DTOs;

import com.example.javacrm.dal.entities.Projet;
import com.example.javacrm.dal.entities.Utilisateur;
import com.example.javacrm.dal.enums.StatutProjet;

import java.time.LocalDate;
import java.util.List;

public record ProjetDTO(
        Integer id,
        String theme,
        String commentaire,
        LocalDate dateCreation,
        LocalDate dateModification,
        LocalDate deadline,
        StatutProjet statut,
        List<UtilisateurProjetDTO> utilisateurs
) {
    public static ProjetDTO fromEntityToDTO(Projet entity){
        return new ProjetDTO(
                entity.getId(),
                entity.getTheme(),
                entity.getCommentaire(),
                entity.getDateCreation(),
                entity.getDateModification(),
                entity.getDeadline(),
                entity.getStatut(),
                entity.getUtilisateurs().stream().map(UtilisateurProjetDTO::fromEntityToDTO).toList()
        );
    }
}
