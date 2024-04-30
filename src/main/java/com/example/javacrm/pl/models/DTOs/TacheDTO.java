package com.example.javacrm.pl.models.DTOs;

import com.example.javacrm.dal.entities.Tache;
import com.example.javacrm.dal.entities.Utilisateur;
import com.example.javacrm.dal.enums.StatutTache;

import java.time.LocalDate;

public record TacheDTO(
        Integer id,
        String objet,
        String description,
        LocalDate dateCreation,
        LocalDate dateModification,
        LocalDate deadline,
        StatutTache statut,
        UtilisateurProjetDTO utilisateur

) {
    public static TacheDTO fromEntityToDTO(Tache entity){
        return new TacheDTO(
                entity.getId(),
                entity.getObjet(),
                entity.getDescription(),
                entity.getDateCreation(),
                entity.getDateModification(),
                entity.getDeadline(),
                entity.getStatut(),
                UtilisateurProjetDTO.fromEntityToDTO(entity.getUtilisateur())
        );
    }
}
