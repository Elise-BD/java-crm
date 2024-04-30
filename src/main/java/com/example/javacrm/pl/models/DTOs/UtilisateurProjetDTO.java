package com.example.javacrm.pl.models.DTOs;

import com.example.javacrm.dal.entities.Tache;
import com.example.javacrm.dal.entities.Utilisateur;

import java.util.List;

public record UtilisateurProjetDTO(
        Integer id,
        String reference,
        String nom,
        String prenom,
        String fonction,
        List<TacheDTO> taches
) {
    public static UtilisateurProjetDTO fromEntityToDTO(Utilisateur entity){
        return new UtilisateurProjetDTO(
                entity.getId(),
                entity.getReference(),
                entity.getNom(),
                entity.getPrenom(),
                entity.getFonction(),
                entity.getTaches().stream().map(TacheDTO::fromEntityToDTO).toList()
        );
    }
}
