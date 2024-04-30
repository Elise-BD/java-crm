package com.example.javacrm.bll.services;

import com.example.javacrm.dal.entities.Projet;
import com.example.javacrm.pl.models.forms.ProjetForm;
import com.example.javacrm.pl.models.forms.ProjetStatutForm;

import java.util.List;
import java.util.Optional;

public interface ProjetService {
    void create(ProjetForm form);

    Optional<Projet> getById(Integer id);

    List<Projet> getAll();

    void update(Integer id, ProjetForm form);

    void updateStatut(Integer id, ProjetStatutForm form);

    void delete(Integer id);

}
