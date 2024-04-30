package com.example.javacrm.bll.services;

import com.example.javacrm.dal.entities.Tache;
import com.example.javacrm.dal.repositories.TacheRepository;
import com.example.javacrm.pl.models.forms.TacheForm;
import com.example.javacrm.pl.models.forms.TacheStatutForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TacheServiceImpl implements TacheService{

    private final TacheRepository tacheRepository;

    public TacheServiceImpl(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    @Override
    public void create(TacheForm form) {

    }

    @Override
    public Optional<Tache> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Tache> getAll() {
        return null;
    }

    @Override
    public void update(Integer id, TacheForm form) {

    }

    @Override
    public void updateStatut(Integer id, TacheStatutForm form) {

    }

    @Override
    public void delete(Integer id) {

    }
}
