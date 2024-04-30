package com.example.javacrm.bll.services;

import com.example.javacrm.dal.entities.Projet;
import com.example.javacrm.dal.enums.StatutProjet;
import com.example.javacrm.dal.repositories.ProjetRepository;
import com.example.javacrm.pl.models.forms.ProjetForm;
import com.example.javacrm.pl.models.forms.ProjetStatutForm;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class ProjetServiceImpl implements ProjetService{

    private final ProjetRepository projetRepository;

    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public void create(ProjetForm form) {
        Projet p = new Projet();
        p.setTheme(form.theme());
        p.setCommentaire(form.commentaire());
        p.setDateCreation(LocalDate.now());
        p.setDateModification(null);
        p.setDeadline(form.deadline());
        p.setStatut(StatutProjet.CREE);
        p.setUtilisateurs(form.utilisateurs());
        projetRepository.save(p);
    }

    @Override
    public Optional<Projet> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Projet> getAll() {
        return null;
    }

    @Override
    public void update(Integer id, ProjetForm form) {

    }

    @Override
    public void updateStatut(Integer id, ProjetStatutForm form) {

    }

    @Override
    public void delete(Integer id) {

    }
}
