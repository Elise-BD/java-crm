package com.example.javacrm.bll.services;

import com.example.javacrm.dal.entities.Tache;
import com.example.javacrm.pl.models.forms.TacheForm;
import com.example.javacrm.pl.models.forms.TacheStatutForm;

import java.util.List;
import java.util.Optional;

public interface TacheService {
    void create(TacheForm form);

    Optional<Tache> getById(Integer id);

    List<Tache> getAll();

    void update(Integer id, TacheForm form);

    void updateStatut(Integer id, TacheStatutForm form);

    void delete(Integer id);
}
