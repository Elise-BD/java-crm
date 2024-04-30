package com.example.javacrm.bll.services;

import com.example.javacrm.dal.entities.Utilisateur;
import com.example.javacrm.pl.models.AuthDTO;
import com.example.javacrm.pl.models.LoginForm;
import com.example.javacrm.pl.models.RegisterForm;

import java.util.Optional;
import java.util.Set;

public interface UtilisateurService {
    void register(RegisterForm form);
    AuthDTO login(LoginForm form);
    Optional<Utilisateur> getOne(String login);
    Set<String> getAllName();
}
